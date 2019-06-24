package com.bangbang.wepay.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangbang.common.annotation.Log;
import com.bangbang.owneruser.comment.GenerateCode;
import com.bangbang.wepay.domain.OrderDO;
import com.bangbang.wepay.domain.PayOrderEntity;
import com.bangbang.wepay.service.OrderService;
import com.bangbang.wepay.utils.HttpXmlUtils;
import com.bangbang.wepay.utils.ParseXMLUtils;
import com.bangbang.wepay.utils.RandCharsUtils;
import com.bangbang.wepay.utils.Unifiedorder;
import com.bangbang.wepay.utils.WXSignUtils;
@RestController
public class WxpayController {
	
	/**
	 * 微信APP支付付款
	 * 
	 * @return JsonObject
	 * @throws Exception
	 */
	private Logger logger = LoggerFactory.getLogger(WxpayController.class);
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="/wxpay/payment/app", method = RequestMethod.POST)
	Map<String,Object> appPayment(
								  @RequestParam("spbill_create_ip")String spbill_create_ip, 
								  @RequestParam("orderNo")String orderNo, 
								  @RequestParam("body")String body, 
								  @RequestParam("totalFee")BigDecimal totalFee, 
							
								  @RequestParam("userId") Long userId,
								  @RequestParam("appid")String appid,
								  @RequestParam("mch_id") String mch_id,
								  @RequestParam("secret") String secret,
								  @RequestParam("balance") Integer balance//时光贝
								 
								 ) {
		Map<String, Object> ret = new HashMap<String, Object>();
		String tradeType = "APP";
		
		String notify_url = "https://nmgshiguangji.com/notifycallback";
		
		String nonce_str = RandCharsUtils.getRandomString(16);

		String out_trade_no = GenerateCode.getUUID();
		
		// 参数：开始生成签名
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", appid);//应用ID
		
		parameters.put("body", body);//商品描述
		parameters.put("mch_id", mch_id);//商户号
		parameters.put("nonce_str", nonce_str);//随机字符串
		parameters.put("notify_url", notify_url);//通知地址	
		parameters.put("out_trade_no", out_trade_no);//商户订单号	
		parameters.put("spbill_create_ip", spbill_create_ip);//终端IP
		parameters.put("total_fee", totalFee);//总金额	
		parameters.put("trade_type", tradeType);//交易类型	
		
		String sign = WXSignUtils.createSign("UTF-8", parameters, secret);//生成签名

		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(appid);
	
		unifiedorder.setBody(body);
		unifiedorder.setMch_id(mch_id);
		unifiedorder.setNonce_str(nonce_str);
		unifiedorder.setNotify_url(notify_url);
		unifiedorder.setOut_trade_no(out_trade_no);
		unifiedorder.setSpbill_create_ip(spbill_create_ip);
		unifiedorder.setTotal_fee(totalFee.intValue());
		unifiedorder.setTrade_type(tradeType);
		unifiedorder.setSign(sign);

		// 构造xml参数
		String xmlInfo = HttpXmlUtils.xmlInfo(unifiedorder);
		String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String method = "POST";

		String weixinPost = HttpXmlUtils.httpsRequest(wxUrl, method, xmlInfo).toString();

		Map<String, Object> retMap = ParseXMLUtils.jdomParseXml(weixinPost);
		String return_code=retMap.get("return_code").toString();
		
		logger.debug("retMap={}",retMap);
		logger.debug("请求统一下单接口返回结果 ==return_code={}",return_code);
		if("FAIL".equals(return_code)){
			/****支付失败结果返回******/
			
		}
		//支付结果
		String result_code=retMap.get("result_code").toString();
		logger.debug("请求统一下单接口返回支付结果 ==return_code={}",result_code);
		if("FAIL".equals(result_code)){
			String err_code=retMap.get("err_code").toString();//返回错误码
			String err_code_des=retMap.get("err_code_des").toString();//错误描述信息
			/**
			 * NOTENOUGH 余额不足
			 * ORDERPAID 商户订单已支付
			 * ORDERCLOSED 订单已关闭
			 * OUT_TRADE_NO_USED 商户订单号重复
			 */
			if("NOTENOUGH".equals(err_code)||
					"ORDERCLOSED".equals(err_code)||
					"ORDERPAID".equals(err_code)||
					"OUT_TRADE_NO_USED".equals(err_code)){
				/*****************失败结果返回*****************/
				ret.put("code", err_code);
				ret.put("msg", err_code_des);
				ret.put("data", null);
				return ret;
			}
			
		}
		
		OrderDO order = new OrderDO();
		order.setAppid(appid);
	
		order.setBody(body);
		order.setCreateTime(new Date());
		order.setCreateUser(userId);
		order.setBalance(balance);
//		order.setGroup(group);
		order.setMchId(mch_id);
		order.setNotifyUrl(notify_url);
		order.setOrderNo(orderNo);
		order.setOutOrderNo(out_trade_no);
		order.setPayWay("WX");
		order.setSpbillCreateIp(spbill_create_ip);
		order.setStatus(0);
		order.setTotalFee(totalFee.divide(new BigDecimal(100)).intValue());
		order.setTradeType(tradeType);
		orderService.save(order);
		
		nonce_str = RandCharsUtils.getRandomString(16);
		String prepay_id=retMap.get("prepay_id").toString();
		SortedMap<Object, Object> parameters1 = new TreeMap<Object, Object>();
		parameters1.put("appid", appid);
		parameters1.put("partnerid", mch_id);
		parameters1.put("prepayid", prepay_id);
		parameters1.put("package", "Sign=WXPay");
		parameters1.put("noncestr", nonce_str);
		long timetoken = System.currentTimeMillis() / 1000;
		parameters1.put("timestamp", timetoken + "");
		parameters1.put("package", "prepay_id="+prepay_id);
		parameters1.put("signType", "MD5");
		
		String ios_resign = WXSignUtils.createSign("UTF-8", parameters1,secret);
		parameters1.put("appid", appid);
		String and_resign = WXSignUtils.createSign("UTF-8", parameters1,secret);
		
		Wchat wchat = new Wchat();
		wchat.setAppid(appid);
		wchat.setPartnerid(mch_id);
		wchat.setPrepayid(prepay_id);//微信返回的支付交易会话ID
		wchat.setNoncestr(nonce_str);//随机串
		wchat.setTimestamp(timetoken + "");
		wchat.setAndsign(and_resign);
		wchat.setIossign(ios_resign);
		ret.put("data", wchat);
		ret.put("code",0);
		ret.put("msg","success");
		return ret;
	}
	
	/**
	 * 根据订单号查询订单状态
	 */
	@Log("根据订单号查询订单状态")
	@GetMapping("/getOrderStatus")
	public Map<String,Object> getOrderStatus(String orderNo){
		OrderDO orderDO = orderService.getOrderStatus(orderNo);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","success");
		map.put("data",orderDO);
		return map;
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/notifycallback")
	public String notifyurl(HttpServletRequest request,HttpServletResponse response){
		InputStream is = null;
		try {
			is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
			String xml = HttpXmlUtils.getContent(is, "UTF-8");
			Map<String, Object> notifyMap = ParseXMLUtils.jdomParseXml(xml);//将微信发的xml转map
					System.out.println("===xml============="+xml);	
					
			if(notifyMap.get("return_code").equals("SUCCESS")){  
	                if(notifyMap.get("result_code").equals("SUCCESS")){  
	                String ordersSn = notifyMap.get("out_trade_no").toString();//商户订单号 
	                String totalFee = notifyMap.get("total_fee").toString();//实际支付的订单金额:单位 分
	                OrderDO order = orderService.getbyno(ordersSn);
	                /**********************修改订单信息************************/
	                if(order!=null){
	                	order.setPayTime(new Date());
	                	order.setStatus(1);
	        		   orderService.update(order);
	              }
	                /**********************添加够买的课程*****************************/
	            }  
	        }
	        //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
	        response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");  
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static class Wchat {
		private String appid;
		private String partnerid;
		private String prepayid;
		private String noncestr;
		private String timestamp;
		private String iossign;
		private String andsign;
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		public String getPartnerid() {
			return partnerid;
		}
		public void setPartnerid(String partnerid) {
			this.partnerid = partnerid;
		}
		public String getPrepayid() {
			return prepayid;
		}
		public void setPrepayid(String prepayid) {
			this.prepayid = prepayid;
		}
		public String getNoncestr() {
			return noncestr;
		}
		public void setNoncestr(String noncestr) {
			this.noncestr = noncestr;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getIossign() {
			return iossign;
		}
		public void setIossign(String iossign) {
			this.iossign = iossign;
		}
		public String getAndsign() {
			return andsign;
		}
		public void setAndsign(String andsign) {
			this.andsign = andsign;
		}
		
	}
}

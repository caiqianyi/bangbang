package com.bangbang.wepay.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.bangbang.common.annotation.Log;
import com.bangbang.owneruser.comment.GenerateCode;
import com.bangbang.wepay.domain.OrderDO;
import com.bangbang.wepay.domain.PayOrderEntity;
import com.bangbang.wepay.service.OrderService;
import com.bangbang.wepay.utils.AliDevPayConfig;
import com.bangbang.wepay.utils.HttpXmlUtils;
import com.bangbang.wepay.utils.ParseXMLUtils;
import com.bangbang.wepay.utils.RandCharsUtils;
import com.bangbang.wepay.utils.Unifiedorder;
import com.bangbang.wepay.utils.WXSignUtils;
import com.bangbang.wepay.utils.WxpayConfig;
@RestController
public class PayController {
	
	/**
	 * APP支付付款
	 * 
	 * @return JsonObject
	 * @throws Exception
	 */
	private Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private OrderService orderService;
	@PostMapping(value="/pay/payment/app")
	 Map<String,Object> appPayment(
								  @RequestParam("spbill_create_ip") String spbill_create_ip, 
								  @RequestParam("body") String body, 
								  @RequestParam("totalFee") BigDecimal totalFee, 
								  @RequestParam("userId") Long userId, 
								  @RequestParam("balance") Integer balance,
								  @RequestParam("PayWay") String PayWay
			
			) {
		
		if(PayWay.equals("WX")){
			return wxpay(spbill_create_ip, body, totalFee, userId, balance, PayWay);
		}
		if(PayWay.equals("ZFB")){
			return goAlipay( body, balance, userId, totalFee);
			
		}
		return null;
		
	}
	
	/**
	 * 微信支付付款
	 */
	private Map<String,Object> wxpay(String spbill_create_ip, String body, BigDecimal totalFee, Long userId, Integer balance,String PayWay){
		Map<String, Object> ret = new HashMap<String, Object>();
		String nonce_str = RandCharsUtils.getRandomString(16);
		String out_trade_no = GenerateCode.getUUID();
		
		// 参数：开始生成签名
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", WxpayConfig.APP_ID);//应用ID
		parameters.put("body", body);//商品描述
		parameters.put("mch_id", WxpayConfig.MEH_ID);//商户号
		parameters.put("nonce_str", nonce_str);//随机字符串
		parameters.put("notify_url", WxpayConfig.NOTIFY_URL);//通知地址	
		parameters.put("out_trade_no", out_trade_no);//商户订单号	
		parameters.put("spbill_create_ip", spbill_create_ip);//终端IP
		parameters.put("total_fee", totalFee);//总金额	
		parameters.put("trade_type", WxpayConfig.TRADE_TYPE);//交易类型	
		String sign = WXSignUtils.createSign("UTF-8", parameters, WxpayConfig.SECRET);//生成签名
		
		Unifiedorder unifiedorder = new Unifiedorder();
		unifiedorder.setAppid(WxpayConfig.APP_ID);
		unifiedorder.setBody(body);
		unifiedorder.setMch_id(WxpayConfig.MEH_ID);
		unifiedorder.setNonce_str(nonce_str);
		unifiedorder.setNotify_url(WxpayConfig.NOTIFY_URL);
		unifiedorder.setOut_trade_no(out_trade_no);
		unifiedorder.setSpbill_create_ip(spbill_create_ip);
		unifiedorder.setTotal_fee(totalFee.intValue());
		unifiedorder.setTrade_type(WxpayConfig.TRADE_TYPE);
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
		order.setAppid(WxpayConfig.APP_ID);
		order.setBody(body);
		order.setCreateTime(new Date());
		order.setCreateUser(userId);
		order.setBalance(balance);
		order.setMchId(WxpayConfig.MEH_ID);
		order.setNotifyUrl(WxpayConfig.NOTIFY_URL);
		String orderNo=GenerateCode.getOrderIdByTime(userId);
		order.setOrderNo(orderNo);
		order.setOutOrderNo(out_trade_no);
		order.setPayWay(PayWay);
		order.setSpbillCreateIp(spbill_create_ip);
		order.setStatus(0);
		order.setTotalFee(totalFee.divide(new BigDecimal(100)).intValue());
		order.setTradeType(WxpayConfig.TRADE_TYPE);
		orderService.save(order);
		
		
		
		nonce_str = RandCharsUtils.getRandomString(16);
		String prepay_id=retMap.get("prepay_id").toString();
		SortedMap<Object, Object> parameters1 = new TreeMap<Object, Object>();
		parameters1.put("appid",WxpayConfig.APP_ID);
//		parameters1.put("package", "Sign=WXPay");
		parameters1.put("prepayid", prepay_id);
		parameters1.put("noncestr", nonce_str);
		long timetoken = System.currentTimeMillis() / 1000;
		parameters1.put("timestamp", timetoken + "");
		parameters1.put("package", "prepay_id="+prepay_id);
		parameters1.put("signType", "MD5");
		
		String resign = WXSignUtils.createSign("UTF-8", parameters1,WxpayConfig.SECRET);
		ret = new HashMap<String, Object>();
		ret.put("appId", WxpayConfig.APP_ID);
		ret.put("timeStamp", timetoken + "");
		ret.put("prepayid", prepay_id);
		ret.put("nonceStr", nonce_str);
		ret.put("package", "prepay_id="+prepay_id);
		ret.put("signType", "MD5");
		ret.put("paySign", resign);
		return ret;
	}
	
	
	
	/**
	 * 微信App支付回调
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
	
	/**
	 * 支付宝付款
	 */
	public Map<String,Object>  goAlipay(String body,Integer balance,Long userId,BigDecimal totalFee){
		//这里你可以做一些存表操作..具体根据你们自己的业务来操作..
		String out_trade_no = GenerateCode.getUUID(); 
		OrderDO order = new OrderDO();
		order.setAppid(AliDevPayConfig.APP_ID);
		order.setBody(body);
		order.setCreateTime(new Date());
		order.setCreateUser(userId);
		order.setBalance(balance);
		order.setTotalFee(totalFee.intValue());
		String orderNo=GenerateCode.getOrderIdByTime(userId);
		order.setOrderNo(orderNo);
		order.setPayWay("ZFB");
		order.setStatus(0);
		order.setTotalFee(totalFee.intValue());
		order.setOutOrderNo(out_trade_no);
		orderService.save(order);
		String orderString = "";//这个字符串是用来返回给前端的
		logger.info("==================支付宝下单,商户订单号为：" + "");
		
		try {
		//实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
		AlipayClient alipayClient =new DefaultAlipayClient(AliDevPayConfig.URL, AliDevPayConfig.APP_ID,AliDevPayConfig.RSA_PRIVATE_KEY,AliDevPayConfig.FORMAT,
				AliDevPayConfig.CHARSET,AliDevPayConfig.SIGNTYPE);
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		//业务参数传入,可以传很多，参考API
		//model.setPassbackParams(URLEncoder.encode(request.getBody().toString())); //公用参数（附加数据）
		//对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
		model.setBody(body);
		//商品名称
		model.setSubject("时光贝");
		//商户订单号(根据业务需求自己生成)
		model.setOutTradeNo(out_trade_no);
		//交易超时时间 这里的30m就是30分钟
		model.setTimeoutExpress("30m");
		//支付金额 后面保留2位小数点..不能超过2位
		model.setTotalAmount(totalFee.toString());
		//销售产品码（固定值） //这个不做多解释..看文档api接口参数解释
		model.setProductCode("QUICK_MSECURITY_PAY");
		ali_request.setBizModel(model);
		//异步回调地址（后台）//这里我在上面的aliPayConfig有讲..自己去看
		ali_request.setNotifyUrl(AliDevPayConfig.NOTIFY_URL);
		logger.info("====================异步通知的地址为：" + ali_request.getNotifyUrl());
		
		// 这里和普通的接口调用不同，使用的是sdkExecute
		//返回支付宝订单信息(预处理)
		AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request);
		//就是orderString 可以直接给APP请求，无需再做处理。
		orderString = alipayTradeAppPayResponse.getBody();
		System.out.println(orderString);
		} catch (AlipayApiException e) {
		e.printStackTrace();
		logger.info("与支付宝交互出错，未能生成订单，请检查代码！");
		}
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("orderString", orderString);
		return map;
		}
	  
	/**
     * 支付宝支付成功后.异步请求该接口
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/aliNotify",method= RequestMethod.POST)
    @ResponseBody
    public String aliNotify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("=支付宝异步返回支付结果开始");
        //1.从支付宝回调的request域中取值
        //获取支付宝返回的参数集合
        Map<String, String[]> aliParams = request.getParameterMap();
        //用以存放转化后的参数集合
        Map<String, String> conversionParams = new HashMap<String, String>();
        for (Iterator<String> iter = aliParams.keySet().iterator(); iter.hasNext();) {
            String key = iter.next();
            String[] values = aliParams.get(key);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            conversionParams.put(key, valueStr);
        }
        System.out.println("==返回参数集合："+conversionParams);
        String status=aliNotifyRun(conversionParams);
        return status;
    }
    
    /**
     * 支付宝支付回调
     */
    public String aliNotifyRun(Map<String, String> conversionParams) {
        logger.info("=支付宝异步请求逻辑处理=");
        //签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
        boolean signVerified = false;
        try {
            //调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(conversionParams, AliDevPayConfig.ALIPAY_PUBLIC_KEY, "UTF-8", "RSA2");
            //对验签进行处理.
            if (signVerified) {
            	logger.info("+支付宝回调签名认证成功+");
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure 支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）
                String tradeStatus = conversionParams.get("trade_status");
 
                //只处理支付成功的订单: 修改交易表状态,支付成功
                //只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
                if (tradeStatus.equals("TRADE_SUCCESS") ||tradeStatus.equals("TRADE_FINISHED")) {
                	 String outTradeNo = conversionParams.get("out_trade_no");
                	 OrderDO order = orderService.getbyno(outTradeNo);
 	                /**********************修改订单信息************************/
 	                if(order!=null){
 	                	order.setPayTime(new Date());
 	                	order.setStatus(1);
 	        		   orderService.update(order);
 	              }
                }
                 
             } 
            
            else{
            	return "fail";
            }
         
        } catch (AlipayApiException e) {
        	logger.info("+++验签失败 ！+++");
            e.printStackTrace();
        }
        return "success";
    }
	
	/**
	 * 根据订单号查询订单状态
	 */
	@Log("根据订单号查询订单状态")
	@GetMapping("/getOrderStatus")
	public Map<String,Object> getOrderStatus(String out_trade_no){
		OrderDO orderDO = orderService.getOrderStatus(out_trade_no);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","success");
		map.put("data",orderDO);
		return map;
	}
	
}

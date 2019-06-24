package com.bangbang.wepay.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.bangbang.wepay.domain.OrderDO;
import com.bangbang.wepay.service.OrderService;
import com.bangbang.wepay.utils.AliDevPayConfig;

public class AlipayController {
	private OrderService orderService;
	private Logger log=LoggerFactory.getLogger(AlipayController.class);
	public String goAlipay(String url,//网关地址
						   String appid,//应用appid
						   String private_key,//私钥 pkcs8格式的
						   String public_key,//支付公钥
						   String orderNo,//订单号
						   String body,//商品描述信息
						   Integer balance,
						   Long userId,//用户id
						   BigDecimal totalFee//金额
									   
			){
	 //这里你可以做一些存表操作..具体根据你们自己的业务来操作...
		
		
		OrderDO order = new OrderDO();
		order.setAppid(appid);
		order.setBody(body);
		order.setCreateTime(new Date());
		order.setCreateUser(userId);
		order.setBalance(balance);
		order.setTotalFee(totalFee.intValue());
		order.setOrderNo(orderNo);
		order.setPayWay("ZFB");
		order.setStatus(0);
		order.setTotalFee(totalFee.intValue());
		orderService.save(order);
    String orderString = "";//这个字符串是用来返回给前端的
    String notify_url = "http://2hu4349021.wicp.vip/pay/aliNotify/aliNotify";
    log.info("==================支付宝下单,商户订单号为：" + orderNo);
  
    try {
        AliDevPayConfig aliDevPayConfig= new  AliDevPayConfig(); //实例化上面的那个配置类..
        //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型），为了取得预付订单信息
        AlipayClient alipayClient =new DefaultAlipayClient(url, appid,private_key,"json","utf-8","RSA2");
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
        model.setOutTradeNo(orderNo);
        //交易超时时间 这里的30m就是30分钟
        model.setTimeoutExpress("30m");
        //支付金额 后面保留2位小数点..不能超过2位
        model.setTotalAmount(10.00+"");
        //销售产品码（固定值） //这个不做多解释..看文档api接口参数解释
        model.setProductCode("QUICK_MSECURITY_PAY");
        ali_request.setBizModel(model);
        //异步回调地址（后台）//这里我在上面的aliPayConfig有讲..自己去看
        ali_request.setNotifyUrl(AliDevPayConfig.notify_url);
        log.info("====================异步通知的地址为：" + ali_request.getNotifyUrl());
        //同步回调地址（APP）同上
        ali_request.setReturnUrl(AliDevPayConfig.return_url);
        log.info("====================同步通知的地址为：" + ali_request.getReturnUrl());

        // 这里和普通的接口调用不同，使用的是sdkExecute
        //返回支付宝订单信息(预处理)
        AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request);
        //就是orderString 可以直接给APP请求，无需再做处理。
        orderString = alipayTradeAppPayResponse.getBody();
        System.out.println(orderString);
    } catch (AlipayApiException e) {
        e.printStackTrace();
        log.info("与支付宝交互出错，未能生成订单，请检查代码！");
    }
    return orderString;
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
    
    public String aliNotifyRun(Map<String, String> conversionParams) {
        log.info("=支付宝异步请求逻辑处理=");
        //签名验证(对支付宝返回的数据验证，确定是支付宝返回的)
        boolean signVerified = false;
        try {
            //调用SDK验证签名
        String alipayPublicKey = AliDevPayConfig.ALIPAY_PUBLIC_KEY;
        String charset = AliDevPayConfig.CHARSET;
        String signType = AliDevPayConfig.SIGNTYPE;
 
            signVerified = AlipaySignature.rsaCheckV1(conversionParams, alipayPublicKey, charset, signType);
            //对验签进行处理.
            if (signVerified) {
                log.info("+支付宝回调签名认证成功+");
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure 支付宝官方建议校验的值（out_trade_no、total_amount、sellerId、app_id）
               String tradeStatus = conversionParams.get("trade_status");
 
                //只处理支付成功的订单: 修改交易表状态,支付成功
                //只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
                if (tradeStatus.equals("TRADE_SUCCESS") ||tradeStatus.equals("TRADE_FINISHED")) {
                    
                    }
                    return "success";
             } else {
                    return "fail";
             }
         
        } catch (AlipayApiException e) {
            log.info("+++验签失败 ！+++");
            e.printStackTrace();
        }
        return "fail";
    }
}


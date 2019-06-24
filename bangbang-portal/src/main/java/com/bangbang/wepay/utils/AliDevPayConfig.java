package com.bangbang.wepay.utils;

/**
 * 支付宝下单基本参数
 */
public class AliDevPayConfig {
	/**
     * 1.商户appid
     */
    public String APPID;
 
    /**
     * 私钥 pkcs8格式的
     */
    public static String RSA_PRIVATE_KEY;
 
    /**
     * 3.支付宝公钥
     */
    public static String ALIPAY_PUBLIC_KEY;
 
    /**
     * 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
//这个着重讲一下..支付完成后,支付宝会通过这个url请求到你的服务端..
//这个url一定是要公网可以访问才行...如果需要测试的话..我后面有讲到..
//这里你可以先写你本地项目的url 例如:localhost:8080/项目名/访问路径
    public static String notify_url = "http://2hu4349021.wicp.vip/pay/aliNotify";
 
    /**
     * 5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
     */
       //这里同上..不做详细说明了..
     public static String return_url = "http://2hu4349021.wicp.vip/pay/returnUrl";
 
    /**
     * 正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
     */
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
 
    /**
     * 7.编码
     */
    public static String CHARSET = "UTF-8";
 
    /**
     * 私钥 pkcs8格式的
     */
    // 8.返回格式
    public static String FORMAT = "json";
 
    /**
     * //签名方式 加密类型
     */
    public static String SIGNTYPE = "RSA2";

	public String getAPPID() {
		return APPID;
	}

	public void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public static String getRSA_PRIVATE_KEY() {
		return RSA_PRIVATE_KEY;
	}

	public static void setRSA_PRIVATE_KEY(String rSA_PRIVATE_KEY) {
		RSA_PRIVATE_KEY = rSA_PRIVATE_KEY;
	}

	public static String getALIPAY_PUBLIC_KEY() {
		return ALIPAY_PUBLIC_KEY;
	}

	public static void setALIPAY_PUBLIC_KEY(String aLIPAY_PUBLIC_KEY) {
		ALIPAY_PUBLIC_KEY = aLIPAY_PUBLIC_KEY;
	}

	public static String getNotify_url() {
		return notify_url;
	}

	public static void setNotify_url(String notify_url) {
		AliDevPayConfig.notify_url = notify_url;
	}

	public static String getReturn_url() {
		return return_url;
	}

	public static void setReturn_url(String return_url) {
		AliDevPayConfig.return_url = return_url;
	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}

	public static String getCHARSET() {
		return CHARSET;
	}

	public static void setCHARSET(String cHARSET) {
		CHARSET = cHARSET;
	}

	public static String getFORMAT() {
		return FORMAT;
	}

	public static void setFORMAT(String fORMAT) {
		FORMAT = fORMAT;
	}

	public static String getSIGNTYPE() {
		return SIGNTYPE;
	}

	public static void setSIGNTYPE(String sIGNTYPE) {
		SIGNTYPE = sIGNTYPE;
	}
    
}

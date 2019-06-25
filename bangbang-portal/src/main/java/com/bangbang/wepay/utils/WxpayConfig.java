package com.bangbang.wepay.utils;

import java.io.Serializable;
import java.util.Date;

public class WxpayConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3033022900682925884L;
	
	public static final String APP_ID="wx604c7cc43b3300e4";
	public static final String MEH_ID="XXXXXXXXXXX";
	public  static final String SECRET="4eb1166c2980c78d2f5fe07dedcb157d";
	public  static final String NOTIFY_URL="https://nmgshiguangji.com/notifycallback";
	public static final  String TRADE_TYPE = "APP";
	public static String getAppId() {
		return APP_ID;
	}
	public static String getMehId() {
		return MEH_ID;
	}
	public static String getSecret() {
		return SECRET;
	}
	public static String getNotifyUrl() {
		return NOTIFY_URL;
	}
	
}

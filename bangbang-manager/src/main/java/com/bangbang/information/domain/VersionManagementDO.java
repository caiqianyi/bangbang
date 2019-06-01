package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-04-16 09:53:33
 */
public class VersionManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//app版本号
	private String appNum;
	//app更新时间
	private Date appUpdateTime;
	//app下载链接
	private String appDownloadLink;
	//app版本说明
	private String appImprint;
	//手机系统 0  Android   1:ios
	private String phoneSystem;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：app版本号
	 */
	public void setAppNum(String appNum) {
		this.appNum = appNum;
	}
	/**
	 * 获取：app版本号
	 */
	public String getAppNum() {
		return appNum;
	}
	/**
	 * 设置：app更新时间
	 */
	public void setAppUpdateTime(Date appUpdateTime) {
		this.appUpdateTime = appUpdateTime;
	}
	/**
	 * 获取：app更新时间
	 */
	public Date getAppUpdateTime() {
		return appUpdateTime;
	}
	/**
	 * 设置：app下载链接
	 */
	public void setAppDownloadLink(String appDownloadLink) {
		this.appDownloadLink = appDownloadLink;
	}
	/**
	 * 获取：app下载链接
	 */
	public String getAppDownloadLink() {
		return appDownloadLink;
	}
	/**
	 * 设置：app版本说明
	 */
	public void setAppImprint(String appImprint) {
		this.appImprint = appImprint;
	}
	/**
	 * 获取：app版本说明
	 */
	public String getAppImprint() {
		return appImprint;
	}
	public String getPhoneSystem() {
		return phoneSystem;
	}
	public void setPhoneSystem(String phoneSystem) {
		this.phoneSystem = phoneSystem;
	}
	
}

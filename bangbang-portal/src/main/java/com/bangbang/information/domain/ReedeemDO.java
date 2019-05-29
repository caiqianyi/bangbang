package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 兑换码发放表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 15:32:01
 */
public class ReedeemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//0兑换课程   1兑换余额  2兑换优惠券，一次使用   3.兑换优惠券，多次使用
	private Integer reedeemType;
	 
	//兑换码
	private String reedeemCode;
	//兑换码名称
	private String reedeemName;
	//发放时间
	private Date sendoutTime;
	//兑换课程编号
	private Long courseId;
	//0已使用   1未使用 2已过期
	private Integer ifUsed;
	//余额
	private Integer reedeemBalance;
	//有效期
	private Integer validity;
	//用户id
	private Long userId;
	//手机号
	private String phone;
	//姓名
	private String name;
	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：兑换码
	 */
	public void setReedeemCode(String reedeemCode) {
		this.reedeemCode = reedeemCode;
	}
	/**
	 * 获取：兑换码
	 */
	public String getReedeemCode() {
		return reedeemCode;
	}
	/**
	 * 设置：发放时间
	 */
	public void setSendoutTime(Date sendoutTime) {
		this.sendoutTime = sendoutTime;
	}
	/**
	 * 获取：发放时间
	 */
	public Date getSendoutTime() {
		return sendoutTime;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：0未使用   1已使用
	 */
	public void setIfUsed(Integer ifUsed) {
		this.ifUsed = ifUsed;
	}
	/**
	 * 获取：0未使用   1已使用
	 */
	public Integer getIfUsed() {
		return ifUsed;
	}
	
	public Integer getReedeemType() {
		return reedeemType;
	}
	public void setReedeemType(Integer reedeemType) {
		this.reedeemType = reedeemType;
	}
	public Integer getReedeemBalance() {
		return reedeemBalance;
	}
	public void setReedeemBalance(Integer reedeemBalance) {
		this.reedeemBalance = reedeemBalance;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public String getReedeemName() {
		return reedeemName;
	}
	public void setReedeemName(String reedeemName) {
		this.reedeemName = reedeemName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
}

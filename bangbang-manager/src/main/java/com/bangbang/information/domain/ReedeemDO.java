package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 兑换码表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 13:35:00
 */
public class ReedeemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//兑换码
	private String reedeemCode;
	//创建时间
	private Date createTime;
	//创建者id
	private Long createId;
	//创建者姓名
	private String createName;
	
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//0兑换课程   1兑换余额  2兑换优惠券，一次使用   3.兑换优惠券，多次使用
	private Integer reedeemType;
	
	//兑换码 0启用   1停用
	private Integer ifStop;
	//兑换码名称
	private String reedeemName;
	//课程编号
	private Long courseId;
	//优惠券编号
	private Long couponId;
	//发放数量
	private Integer reedeemCount;
	//剩余数量
	private Integer reedeemSurplus;
	//优惠券余额
	private Integer reedeemBalance;
	//兑换码有效期
	private Integer validity;
	//课程名
	private String courseName;
	//用户名
	private String username;
	//手机号
	private String phone;
	//真实姓名
	private String name;
	//是否兑换    0已兑换   1未兑换
	private Integer ifUsed;
	//用户id
	private Long userId;
	
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置：删除标志  0 未删除   1已删除
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：删除标志  0 未删除   1已删除
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public Integer getReedeemType() {
		return reedeemType;
	}
	public void setReedeemType(Integer reedeemType) {
		this.reedeemType = reedeemType;
	}
	
	public Integer getIfStop() {
		return ifStop;
	}
	public void setIfStop(Integer ifStop) {
		this.ifStop = ifStop;
	}
	
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getReedeemName() {
		return reedeemName;
	}
	public void setReedeemName(String reedeemName) {
		this.reedeemName = reedeemName;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Integer getReedeemCount() {
		return reedeemCount;
	}
	public void setReedeemCount(Integer reedeemCount) {
		this.reedeemCount = reedeemCount;
	}
	public Integer getReedeemSurplus() {
		return reedeemSurplus;
	}
	public void setReedeemSurplus(Integer reedeemSurplus) {
		this.reedeemSurplus = reedeemSurplus;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getCouponId() {
		return couponId;
	}
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Integer getIfUsed() {
		return ifUsed;
	}
	public void setIfUsed(Integer ifUsed) {
		this.ifUsed = ifUsed;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	

}

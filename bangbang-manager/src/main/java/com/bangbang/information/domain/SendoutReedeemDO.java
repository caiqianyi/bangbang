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
public class SendoutReedeemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//兑换码id
	private Long reedeemId;
	//0兑换课程   1兑换余额  2兑换优惠券，一次使用   3.兑换优惠券，多次使用
	private Integer reedeemType;
	
	//兑换码
	private String reedeemCode;
	//发放时间
	private Date sendoutTime;
	
	//过期显示
	private String usereedem;
	//用户id
	private Long userId;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//0未使用   1已使用
	private Integer ifUsed;
	private Long[] userIdArray;
	//课程名
	private String courseName;
	//优惠券余额
	private Integer reedeemBalance;
	//有效期
	private Integer validity;
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
	
	public Long getReedeemId() {
		return reedeemId;
	}
	public void setReedeemId(Long reedeemId) {
		this.reedeemId = reedeemId;
	}
	public Integer getReedeemType() {
		return reedeemType;
	}
	public void setReedeemType(Integer reedeemType) {
		this.reedeemType = reedeemType;
	}
	public Long[] getUserIdArray() {
		return userIdArray;
	}
	public void setUserIdArray(Long[] userIdArray) {
		this.userIdArray = userIdArray;
	}
	public String getUsecoupon() {
		return usereedem;
	}
	public void setUsecoupon(String reedem) {
		this.usereedem = reedem;
	}
	public String getUsereedem() {
		return usereedem;
	}
	public void setUsereedem(String usereedem) {
		this.usereedem = usereedem;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	
}

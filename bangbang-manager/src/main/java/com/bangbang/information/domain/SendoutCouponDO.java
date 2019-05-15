package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 优惠券发放表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 13:53:53
 */
public class SendoutCouponDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//优惠券编号
	private Long couponId;
	//用户id
	private Long userId;
	//优惠券名称
	private String countName;
	//优惠券金额
	private Long couponBalance;
	//发放数量
	private Integer count;
	//有效期
	private Integer validity;
	//已使用的优惠券
	private Integer ifUser;
	//优惠券有效截止日期
	private Date expirationDate;
	//使用条件
	private String usecondition;
	//发放时间
	private Date sendoutTime;
	//0 新注册用户   1购买商品     2消费金额
	private Integer couponGroup;
	//优惠券使用情况
	private String usecoupon;
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
	 * 设置：优惠券编号
	 */
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：优惠券编号
	 */
	public Long getCouponId() {
		return couponId;
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
	 * 设置：发放数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：发放数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	/**
	 * 获取：有效期
	 */
	public Integer getValidity() {
		return validity;
	}
	/**
	 * 设置：0 未使用   1已使用     2已过期
	 */
	public void setIfUser(Integer ifUser) {
		this.ifUser = ifUser;
	}
	/**
	 * 获取：0 未使用   1已使用     2已过期
	 */
	public Integer getIfUser() {
		return ifUser;
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
	 * 设置：0 新注册用户   1购买商品     2消费金额
	 */
	public void setCouponGroup(Integer couponGroup) {
		this.couponGroup = couponGroup;
	}
	/**
	 * 获取：0 新注册用户   1购买商品     2消费金额
	 */
	public Integer getCouponGroup() {
		return couponGroup;
	}
	
	public String getCountName() {
		return countName;
	}
	public void setCountName(String countName) {
		this.countName = countName;
	}
	public Long getCouponBalance() {
		return couponBalance;
	}
	public void setCouponBalance(Long couponBalance) {
		this.couponBalance = couponBalance;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getUsecoupon() {
		return usecoupon;
	}
	public void setUsecoupon(String usecoupon) {
		this.usecoupon = usecoupon;
	}
	public String getUsecondition() {
		return usecondition;
	}
	public void setUsecondition(String usecondition) {
		this.usecondition = usecondition;
	}
}

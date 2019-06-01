package com.bangbang.information.domain;

import java.util.Date;

public class CouponDO {
	//id
		private Long id;
		//优惠券编号
		private Long couponId;
		//用户id
		private Long userId;
		//优惠券名称
		private String couponName;
		//优惠券金额
		private Long couponBalance;
		//有效期
		private Integer validity;
		//已使用的优惠券  0已使用   1未使用 2已过期
		private Integer ifUser;
		//使用条件
		private Integer usecondition;
		//发放时间
		private Date sendoutTime;
		//有效期
		private Date validityTime;
		//0 新注册用户   1购买商品     2消费金额 3兑换码兑换
		private Integer couponGroup;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getCouponId() {
			return couponId;
		}
		public void setCouponId(Long couponId) {
			this.couponId = couponId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getCouponName() {
			return couponName;
		}
		public void setCouponName(String couponName) {
			this.couponName = couponName;
		}
		public Long getCouponBalance() {
			return couponBalance;
		}
		public void setCouponBalance(Long couponBalance) {
			this.couponBalance = couponBalance;
		}
		public Integer getValidity() {
			return validity;
		}
		public void setValidity(Integer validity) {
			this.validity = validity;
		}
		public Integer getIfUser() {
			return ifUser;
		}
		public void setIfUser(Integer ifUser) {
			this.ifUser = ifUser;
		}
		public Integer getUsecondition() {
			return usecondition;
		}
		public void setUsecondition(Integer usecondition) {
			this.usecondition = usecondition;
		}
		public Date getSendoutTime() {
			return sendoutTime;
		}
		public void setSendoutTime(Date sendoutTime) {
			this.sendoutTime = sendoutTime;
		}
		public Integer getCouponGroup() {
			return couponGroup;
		}
		public void setCouponGroup(Integer couponGroup) {
			this.couponGroup = couponGroup;
		}
		public Date getValidityTime() {
			return validityTime;
		}
		public void setValidityTime(Date validityTime) {
			this.validityTime = validityTime;
		}
		
	
}

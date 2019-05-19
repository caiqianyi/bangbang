package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 14:33:26
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//支付订单号
	private String orderNo;
	//用户id
	private Integer userId;
	//支付金额
	private Float totalFee;
	//订单状态
	private Integer status;
	//支付ip
	private String spbillCreateIp;
	//商户ip
	private String mchId;
	//付款方式
	private String payWay;
	//账单分类
	private String payType;
	//
	private Date createTime;
	//备注
	private String remark;
	//
	private String outRefundNo;
	//
	private Integer count;
	//
	private Date time;
	//
	private String type;

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
	 * 设置：支付订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：支付订单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：支付金额
	 */
	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 获取：支付金额
	 */
	public Float getTotalFee() {
		return totalFee;
	}
	/**
	 * 设置：订单状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：支付ip
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	/**
	 * 获取：支付ip
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	/**
	 * 设置：商户ip
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 获取：商户ip
	 */
	public String getMchId() {
		return mchId;
	}
	/**
	 * 设置：付款方式
	 */
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	/**
	 * 获取：付款方式
	 */
	public String getPayWay() {
		return payWay;
	}
	/**
	 * 设置：账单分类
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：账单分类
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}
	/**
	 * 获取：
	 */
	public String getOutRefundNo() {
		return outRefundNo;
	}
	/**
	 * 设置：
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * 设置：
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
}

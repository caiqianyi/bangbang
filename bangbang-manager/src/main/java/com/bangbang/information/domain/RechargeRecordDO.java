package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 17:38:48
 */
public class RechargeRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//
	private Integer rechargeId;
	//充值金额
	private Float rechargeMoney;
	//充值类型
	private String rechargeType;
	//
	private String rechargeWay;
	//
	private Date rechargeTime;
	//充值订单号
	private String rechargeNo;
	//
	private String rechargeRemarks;
	//
	private Integer count;
	//
	private Date time;
	//
	private String name;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setRechargeId(Integer rechargeId) {
		this.rechargeId = rechargeId;
	}
	/**
	 * 获取：
	 */
	public Integer getRechargeId() {
		return rechargeId;
	}
	/**
	 * 设置：充值金额
	 */
	public void setRechargeMoney(Float rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	/**
	 * 获取：充值金额
	 */
	public Float getRechargeMoney() {
		return rechargeMoney;
	}
	/**
	 * 设置：充值类型
	 */
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	/**
	 * 获取：充值类型
	 */
	public String getRechargeType() {
		return rechargeType;
	}
	/**
	 * 设置：
	 */
	public void setRechargeWay(String rechargeWay) {
		this.rechargeWay = rechargeWay;
	}
	/**
	 * 获取：
	 */
	public String getRechargeWay() {
		return rechargeWay;
	}
	/**
	 * 设置：
	 */
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	/**
	 * 获取：
	 */
	public Date getRechargeTime() {
		return rechargeTime;
	}
	/**
	 * 设置：充值订单号
	 */
	public void setRechargeNo(String rechargeNo) {
		this.rechargeNo = rechargeNo;
	}
	/**
	 * 获取：充值订单号
	 */
	public String getRechargeNo() {
		return rechargeNo;
	}
	/**
	 * 设置：
	 */
	public void setRechargeRemarks(String rechargeRemarks) {
		this.rechargeRemarks = rechargeRemarks;
	}
	/**
	 * 获取：
	 */
	public String getRechargeRemarks() {
		return rechargeRemarks;
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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
}

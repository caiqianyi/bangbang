package com.dingshi.information.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;



/**
 * 货源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-09-27 10:21:16
 */
public class GoodsResourcesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//0：物业费；1：维修费
	private Integer type;
	//订单号
	private String orderNum;
	//订单金额
	private Double orderMoney;
	//用户id
	private Integer userId;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getsAdress() {
		return sAdress;
	}
	public String geteAdress() {
		return eAdress;
	}
	//业主id
	private Integer ownerId;
	//联系人
	private String linkman;
	//联系电话
	private String phone;
	//所在小区
	private String plot;
	//金额
	private Double money;
	//缴费类型
	private Integer payType;
	//维修类型
	private Integer maintainType;
	//订单状态
	private Integer orderType;
	//维修时间
	private Date maintainTime;
	//订单备注
	private String orderDetails;
	//完成时间
	private Timestamp startTime;
	//添加时间
	private Date addTime;
	//修改时间
	private Date updateTime;
	//0：是；1：否
	private Integer deleteFlg;
	//始发地
	private String sAdress;
	//目的地
	private String eAdress;
	//货车车长
	private String carSize;
	//车类型
	private String carType;
	//货物类型
	private String goodsType;
	//货物重量
	private String goodsWeight;
	//司机ID
	private Integer driverId;
	//司机号码
	private String driverPhone;
	
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
	 * 设置：0：物业费；1：维修费
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：0：物业费；1：维修费
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：订单金额
	 */
	public void setOrderMoney(Double orderMoney) {
		this.orderMoney = orderMoney;
	}
	/**
	 * 获取：订单金额
	 */
	public Double getOrderMoney() {
		return orderMoney;
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
	 * 设置：业主id
	 */
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * 获取：业主id
	 */
	public Integer getOwnerId() {
		return ownerId;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkman() {
		return linkman;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：所在小区
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}
	/**
	 * 获取：所在小区
	 */
	public String getPlot() {
		return plot;
	}
	/**
	 * 设置：金额
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：缴费类型
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：缴费类型
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：维修类型
	 */
	public void setMaintainType(Integer maintainType) {
		this.maintainType = maintainType;
	}
	/**
	 * 获取：维修类型
	 */
	public Integer getMaintainType() {
		return maintainType;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderType() {
		return orderType;
	}
	/**
	 * 设置：维修时间
	 */
	public void setMaintainTime(Date maintainTime) {
		this.maintainTime = maintainTime;
	}
	/**
	 * 获取：维修时间
	 */
	public Date getMaintainTime() {
		return maintainTime;
	}
	/**
	 * 设置：订单备注
	 */
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	/**
	 * 获取：订单备注
	 */
	public String getOrderDetails() {
		return orderDetails;
	}
	/**
	 * 设置：完成时间
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：0：是；1：否
	 */
	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	/**
	 * 获取：0：是；1：否
	 */
	public Integer getDeleteFlg() {
		return deleteFlg;
	}
	/**
	 * 设置：始发地
	 */
	public void setSAdress(String sAdress) {
		this.sAdress = sAdress;
	}
	/**
	 * 获取：始发地
	 */
	public String getSAdress() {
		return sAdress;
	}
	/**
	 * 设置：目的地
	 */
	public void setEAdress(String eAdress) {
		this.eAdress = eAdress;
	}
	/**
	 * 获取：目的地
	 */
	public String getEAdress() {
		return eAdress;
	}
	/**
	 * 设置：货车车长
	 */
	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}
	/**
	 * 获取：货车车长
	 */
	public String getCarSize() {
		return carSize;
	}
	/**
	 * 设置：车类型
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * 获取：车类型
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * 设置：货物类型
	 */
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：货物类型
	 */
	public String getGoodsType() {
		return goodsType;
	}
	/**
	 * 设置：货物重量
	 */
	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	/**
	 * 获取：货物重量
	 */
	public String getGoodsWeight() {
		return goodsWeight;
	}
	/**
	 * 设置：司机ID
	 */
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	/**
	 * 获取：司机ID
	 */
	public Integer getDriverId() {
		return driverId;
	}
	/**
	 * 设置：司机号码
	 */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	/**
	 * 获取：司机号码
	 */
	public String getDriverPhone() {
		return driverPhone;
	}
	
	public void setsAdress(String sAdress) {
		this.sAdress = sAdress;
	}
	public void seteAdress(String eAdress) {
		this.eAdress = eAdress;
	}
}

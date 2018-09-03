package com.dingshi.information.domain;

import com.dingshi.owneruser.domain.OwnerUserDO;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auth:wuqiang
 * @Description:
 * @Date:2018/9/1 12:07
 * @Version:1.0
 */

public class OrderDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //订单编号
    private Integer orderNum;
    //订单金额
    private Integer orderMoney;
    //缴费类型
    private Integer payType;
    //订单状态
    private Integer orderType;
    //订单备注
    private String orderDetails;
    //联系人ID
    private Integer userId;
    //联系人
    private String linkman;
    //联系电话
    private String phone;
    //始发地
    private String sAdress;
    //目的地
    private String eAdress;
    //货车车长
    private String carSize;
    //货车类型
    private String carType;
    //货物类型
    private String goodsType;
    //货物重量
    private String goodsWeight;
    //完成时间
    private Date starTime;
    //添加时间
    private Date addTime;
    //修改时间
    private Date updateTime;
    //司机ID
    private Integer driverId;
    //司机手机号码
    private String driverPhone;
    //0：是；1：否
    private Integer daleteFlag;


    /**
     * 获取: id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置: id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取: 订单编号
     */
    public Integer getOrderNum() {
        return this.orderNum;
    }

    /**
     * 设置: 订单编号
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取: 订单金额
     */
    public Integer getOrderMoney() {
        return this.orderMoney;
    }

    /**
     * 设置: 订单金额
     */
    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    /**
     * 获取: 缴费类型
     */
    public Integer getPayType() {
        return this.payType;
    }

    /**
     * 设置: 缴费类型
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取: 订单状态
     */
    public Integer getOrderType() {
        return this.orderType;
    }

    /**
     * 设置: 订单状态
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取: 订单备注
     */
    public String getOrderDetails() {
        return this.orderDetails;
    }

    /**
     * 设置: 订单备注
     */
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * 获取: 联系人ID
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 设置: 联系人ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取: 联系人
     */
    public String getLinkman() {
        return this.linkman;
    }

    /**
     * 设置: 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * 获取: 联系电话
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 设置: 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取: 始发地
     */
    public String getSAdress() {
        return this.sAdress;
    }

    /**
     * 设置: 始发地
     */
    public void setSAdress(String sAdress) {
        this.sAdress = sAdress;
    }

    /**
     * 获取: 目的地
     */
    public String getEAdress() {
        return this.eAdress;
    }

    /**
     * 设置: 目的地
     */
    public void setEAdress(String eAdress) {
        this.eAdress = eAdress;
    }

    /**
     * 获取: 货车车长
     */
    public String getCarSize() {
        return this.carSize;
    }

    /**
     * 设置: 货车车长
     */
    public void setCarSize(String carSize) {
        this.carSize = carSize;
    }

    /**
     * 获取: 货车类型
     */
    public String getCarType() {
        return this.carType;
    }

    /**
     * 设置: 货车类型
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取: 货物类型
     */
    public String getGoodsType() {
        return this.goodsType;
    }

    /**
     * 设置: 货物类型
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 获取: 货物重量
     */
    public String getGoodsWeight() {
        return this.goodsWeight;
    }

    /**
     * 设置: 货物重量
     */
    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    /**
     * 获取: 完成时间
     */
    public Date getStarTime() {
        return this.starTime;
    }

    /**
     * 设置: 完成时间
     */
    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    /**
     * 获取: 添加时间
     */
    public Date getAddTime() {
        return this.addTime;
    }

    /**
     * 设置: 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取: 修改时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置: 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取: 司机ID
     */
    public Integer getDriverId() {
        return this.driverId;
    }

    /**
     * 设置: 司机ID
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * 获取: 司机手机号码
     */
    public String getDriverPhone() {
        return this.driverPhone;
    }

    /**
     * 设置: 司机手机号码
     */
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    /**
     * 获取: 0：是；1：否
     */
    public Integer getDaleteFlag() {
        return this.daleteFlag;
    }

    /**
     * 设置: 0：是；1：否
     */
    public void setDaleteFlag(Integer daleteFlag) {
        this.daleteFlag = daleteFlag;
    }
}

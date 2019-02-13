package com.zhenjiu.users.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;



/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-09-27 10:18:38
 */
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//微信id
	private String openId;
	//昵称
	private String nickname;
	//密码
	private String password;
	//手机号
	private String phone;
	//头像
	private String heardUrl;
	//真实姓名
	private String name;
	//身份证号
	private String identityCard;
	//注册时间
	private Timestamp registerTime;
	//消费金额
	private Double payNum;
	//服务次数
	private Integer serveNum;
	//余额
	private Double balance;
	//返还
	private Double restitution;
	//缴费日期
	private Date payTime;
	//最后登录时间
	private Date loginTime;
	//添加时间
	private Date addTime;
	//修改时间
	private Date updateTime;
	//0：是；1：否
	private Integer deleteFlag;
	//
	private String username;
	//车牌号
	private String carNum;
	//货车类型
	private String carType;
	//车大小
	private String carSize;
	//0:空载  1：非空载
	private Integer carStatus;
	//备注
	private String desc;
	//司机城市
	private String address;
	//拒单率
	private Double refuse;
	//准时率
	private Double ontime;

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
	 * 设置：微信id
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：微信id
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：头像
	 */
	public void setHeardUrl(String heardUrl) {
		this.heardUrl = heardUrl;
	}
	/**
	 * 获取：头像
	 */
	public String getHeardUrl() {
		return heardUrl;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdentityCard() {
		return identityCard;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * 设置：消费金额
	 */
	public void setPayNum(Double payNum) {
		this.payNum = payNum;
	}
	/**
	 * 获取：消费金额
	 */
	public Double getPayNum() {
		return payNum;
	}
	/**
	 * 设置：服务次数
	 */
	public void setServeNum(Integer serveNum) {
		this.serveNum = serveNum;
	}
	/**
	 * 获取：服务次数
	 */
	public Integer getServeNum() {
		return serveNum;
	}
	/**
	 * 设置：余额
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/**
	 * 获取：余额
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * 设置：返还
	 */
	public void setRestitution(Double restitution) {
		this.restitution = restitution;
	}
	/**
	 * 获取：返还
	 */
	public Double getRestitution() {
		return restitution;
	}
	/**
	 * 设置：缴费日期
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：缴费日期
	 */
	public Date getPayTime() {
		return payTime;
	}
	/**
	 * 设置：最后登录时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * 获取：最后登录时间
	 */
	public Date getLoginTime() {
		return loginTime;
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
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：0：是；1：否
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 设置：
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：车牌号
	 */
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	/**
	 * 获取：车牌号
	 */
	public String getCarNum() {
		return carNum;
	}
	/**
	 * 设置：货车类型
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * 获取：货车类型
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * 设置：车大小
	 */
	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}
	/**
	 * 获取：车大小
	 */
	public String getCarSize() {
		return carSize;
	}
	/**
	 * 设置：0:空载  1：非空载
	 */
	public void setCarStatus(Integer carStatus) {
		this.carStatus = carStatus;
	}
	/**
	 * 获取：0:空载  1：非空载
	 */
	public Integer getCarStatus() {
		return carStatus;
	}
	/**
	 * 设置：备注
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：备注
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：司机城市
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：司机城市
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：拒单率
	 */
	public void setRefuse(Double refuse) {
		this.refuse = refuse;
	}
	/**
	 * 获取：拒单率
	 */
	public Double getRefuse() {
		return refuse;
	}
	/**
	 * 设置：准时率
	 */
	public void setOntime(Double ontime) {
		this.ontime = ontime;
	}
	/**
	 * 获取：准时率
	 */
	public Double getOntime() {
		return ontime;
	}
}

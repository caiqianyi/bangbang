package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 10:03:50
 */
public class SubscriberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//头像
	private String heardUrl;
	//用户名
	private String username;
	//签名
	private String signName;
	//性别：值为1时是男性，值为2时是女性，值为0时是未知
	private Integer sex;
	//出生年月
	private Date birthday;
	//最后登录时间
	private Date loginTime;
	//总使用时间
	private Long usedTime;
	//时光贝
	private Double balance;
	//昵称
	private String nickname;
	//用户id
	private Long userId;
	//微信id
	private String openId;
	//密码
	private String password;
	//手机号
	private String phone;
	//真实姓名
	private String name;
	//注册时间
	private Date registerTime;
	//编辑时间
	private Date updateTime;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//用户名或手机号
	private String nameORphone;
	
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
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：签名
	 */
	public void setSignName(String signName) {
		this.signName = signName;
	}
	/**
	 * 获取：签名
	 */
	public String getSignName() {
		return signName;
	}
	/**
	 * 设置：性别：值为1时是男性，值为2时是女性，值为0时是未知
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别：值为1时是男性，值为2时是女性，值为0时是未知
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：出生年月
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生年月
	 */
	public Date getBirthday() {
		return birthday;
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
	 * 设置：总使用时间
	 */
	public void setUsedTime(Long usedTime) {
		this.usedTime = usedTime;
	}
	/**
	 * 获取：总使用时间
	 */
	public Long getUsedTime() {
		return usedTime;
	}
	/**
	 * 设置：时光贝
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/**
	 * 获取：时光贝
	 */
	public Double getBalance() {
		return balance;
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
	 * 设置：注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	/**
	 * 设置：编辑时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：编辑时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 获取：用户名或手机号
	 */
	public String getNameORphone() {
		return nameORphone;
	}
	/**
	 * 设置用户名或手机号
	 */
	public void setNameORphone(String nameORphone) {
		this.nameORphone = nameORphone;
	}
}

package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;



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

	//时光贝
	private Integer balance;
	//昵称
	private String nickname;
	//微信id
	private String openId;
	
	//手机号
	private String phone;
	//真实姓名
	private String name;
	
	
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	
	//手机系统 0 android 1 ios 2其他
	private Integer phoneSystem;
	//注册来源
	private String registrationSource ;
	//头像
	private MultipartFile headSculpture; 
	//留言条数
	private Integer leaveMessageCount;
	//提问条数
	private Integer askCount;
	//连续学习天数
	private Long studyContinuity ;
    //学习总的时间（单位  ：分钟）
	private Long studyTime;
	//优惠券的数量
	private Integer couponCount;
	
	private List<String> days = new ArrayList<String>();
	private List<String> hours = new ArrayList<String>();
	
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
	 * 设置：时光贝
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	/**
	 * 获取：时光贝
	 */
	public Integer getBalance() {
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
	public Integer getPhoneSystem() {
		return phoneSystem;
	}
	public void setPhoneSystem(Integer phoneSystem) {
		this.phoneSystem = phoneSystem;
	}
	public String getRegistrationSource() {
		return registrationSource;
	}
	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}
	public MultipartFile getHeadSculpture() {
		return headSculpture;
	}
	public void setHeadSculpture(MultipartFile headSculpture) {
		this.headSculpture = headSculpture;
	}
	public Integer getLeaveMessageCount() {
		return leaveMessageCount;
	}
	public void setLeaveMessageCount(Integer leaveMessageCount) {
		this.leaveMessageCount = leaveMessageCount;
	}
	public Integer getAskCount() {
		return askCount;
	}
	public void setAskCount(Integer askCount) {
		this.askCount = askCount;
	}
	public Long getStudyContinuity() {
		return studyContinuity;
	}
	public void setStudyContinuity(Long studyContinuity) {
		this.studyContinuity = studyContinuity;
	}
	public Long getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(Long studyTime) {
		this.studyTime = studyTime;
	}
	public Integer getCouponCount() {
		return couponCount;
	}
	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}
	public List<String> getDays() {
		return days;
	}
	public void setDays(List<String> days) {
		this.days = days;
	}
	public List<String> getHours() {
		return hours;
	}
	public void setHours(List<String> hours) {
		this.hours = hours;
	}
	
	
	
}

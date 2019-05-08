package com.zhenjiu.expert.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-15 09:53:23
 */
public class ExpertDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//删除状态   0-未删除   1-已删除
	private Integer deleted;
	//医生等级
	private Integer doctorLevel;
	//医生姓名
	private String doctorName;
	//医生编号
	private String doctorNum;
	//性别
	private String sex;
	//年龄
	private Integer age;
	//身份证号
	private String idCard;
	//医龄
	private Integer workTime;
	//手机号码
	private String phone;
	//常用邮箱
	private String email;
	//个人情况介绍
	private String persenIntroduce;
	//所属医院
	private String nowHospital;
	//所属科室
	private String diagnoseDepartment;
	//擅长
	private String goodAt;
	//头像
	private MultipartFile touxiang; 
	
	
	private String headshot;
	//所获荣誉
	private String honor;
	//医院所在地
	private String hospitalArea;
	//医院等级 一甲、二甲、三甲
	private String hospitalGrade;
	//在院职称
	private String hospitalJob;
	//在线状态 0在线——1离线
	private Integer isLogin;
	//登录总次数
	private Integer loginCount;
	//最后登录时间
	private Date loginTime;
	//开始上班时间
	private Date workStarttime;
	//结束上班时间
	private Date workEndtime;
	//现所在地
	private String nowArea;
	//添加时间
	private Date addTime;
	//修改时间
	private Date updateTime;
	//备注
	private String remark;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：删除状态   0-未删除   1-已删除
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：删除状态   0-未删除   1-已删除
	 */
	public Integer getDeleted() {
		return deleted;
	}
	/**
	 * 设置：医生等级
	 */
	public void setDoctorLevel(Integer doctorLevel) {
		this.doctorLevel = doctorLevel;
	}
	/**
	 * 获取：医生等级
	 */
	public Integer getDoctorLevel() {
		return doctorLevel;
	}
	/**
	 * 设置：医生姓名
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * 获取：医生姓名
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * 设置：医生编号
	 */
	public void setDoctorNum(String doctorNum) {
		this.doctorNum = doctorNum;
	}
	/**
	 * 获取：医生编号
	 */
	public String getDoctorNum() {
		return doctorNum;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：医龄
	 */
	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
	}
	/**
	 * 获取：医龄
	 */
	public Integer getWorkTime() {
		return workTime;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：常用邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：常用邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：个人情况介绍
	 */
	public void setPersenIntroduce(String persenIntroduce) {
		this.persenIntroduce = persenIntroduce;
	}
	/**
	 * 获取：个人情况介绍
	 */
	public String getPersenIntroduce() {
		return persenIntroduce;
	}
	/**
	 * 设置：所属医院
	 */
	public void setNowHospital(String nowHospital) {
		this.nowHospital = nowHospital;
	}
	/**
	 * 获取：所属医院
	 */
	public String getNowHospital() {
		return nowHospital;
	}
	/**
	 * 设置：所属科室
	 */
	public void setDiagnoseDepartment(String diagnoseDepartment) {
		this.diagnoseDepartment = diagnoseDepartment;
	}
	/**
	 * 获取：所属科室
	 */
	public String getDiagnoseDepartment() {
		return diagnoseDepartment;
	}
	/**
	 * 设置：擅长
	 */
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	/**
	 * 获取：擅长
	 */
	public String getGoodAt() {
		return goodAt;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadshot(String headshot) {
		this.headshot = headshot;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadshot() {
		return headshot;
	}
	/**
	 * 设置：所获荣誉
	 */
	public void setHonor(String honor) {
		this.honor = honor;
	}
	/**
	 * 获取：所获荣誉
	 */
	public String getHonor() {
		return honor;
	}
	/**
	 * 设置：医院所在地
	 */
	public void setHospitalArea(String hospitalArea) {
		this.hospitalArea = hospitalArea;
	}
	/**
	 * 获取：医院所在地
	 */
	public String getHospitalArea() {
		return hospitalArea;
	}
	/**
	 * 设置：医院等级 一甲、二甲、三甲
	 */
	public void setHospitalGrade(String hospitalGrade) {
		this.hospitalGrade = hospitalGrade;
	}
	/**
	 * 获取：医院等级 一甲、二甲、三甲
	 */
	public String getHospitalGrade() {
		return hospitalGrade;
	}
	/**
	 * 设置：在院职称
	 */
	public void setHospitalJob(String hospitalJob) {
		this.hospitalJob = hospitalJob;
	}
	/**
	 * 获取：在院职称
	 */
	public String getHospitalJob() {
		return hospitalJob;
	}
	/**
	 * 设置：在线状态 0离线——1在线
	 */
	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}
	/**
	 * 获取：在线状态 0离线——1在线
	 */
	public Integer getIsLogin() {
		return isLogin;
	}
	/**
	 * 设置：登录总次数
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**
	 * 获取：登录总次数
	 */
	public Integer getLoginCount() {
		return loginCount;
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
	 * 设置：开始上班时间
	 */
	public void setWorkStarttime(Date workStarttime) {
		this.workStarttime = workStarttime;
	}
	/**
	 * 获取：开始上班时间
	 */
	public Date getWorkStarttime() {
		return workStarttime;
	}
	/**
	 * 设置：结束上班时间
	 */
	public void setWorkEndtime(Date workEndtime) {
		this.workEndtime = workEndtime;
	}
	/**
	 * 获取：结束上班时间
	 */
	public Date getWorkEndtime() {
		return workEndtime;
	}
	/**
	 * 设置：现所在地
	 */
	public void setNowArea(String nowArea) {
		this.nowArea = nowArea;
	}
	/**
	 * 获取：现所在地
	 */
	public String getNowArea() {
		return nowArea;
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
	
	public MultipartFile getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(MultipartFile touxiang) {
		this.touxiang = touxiang;
	}
}

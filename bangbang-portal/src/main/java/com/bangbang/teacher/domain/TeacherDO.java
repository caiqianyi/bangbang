package com.bangbang.teacher.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



/**
 * 讲师表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 09:37:37
 */
public class TeacherDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//讲师编号
	private Long teacherId;
	//讲师姓名
	private String name;
	//手机号
	private String phone;
	//密码
	private String password;
	//性别 1：女 2：男
	private Integer sex;
	//讲师主讲科目
	private String speakCourse;
	//头像
	private String headUrl;
	//讲师所在学校
	private String teacherSchool;
	//添加时间
	private Date addTime;
	//更新时间
	private Date updateTime;
	//状态
	private Integer status;
	
	private MultipartFile imgFile;


	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
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
	 * 设置：讲师编号
	 */
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：讲师编号
	 */
	public Long getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：讲师姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：讲师姓名
	 */
	public String getName() {
		return name;
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
	 * 设置：性别 1：女 2：男
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别 1：女 2：男
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：讲师主讲科目
	 */
	public void setSpeakCourse(String speakCourse) {
		this.speakCourse = speakCourse;
	}
	/**
	 * 获取：讲师主讲科目
	 */
	public String getSpeakCourse() {
		return speakCourse;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadUrl() {
		return headUrl;
	}
	/**
	 * 设置：讲师所在学校
	 */
	public void setTeacherSchool(String teacherSchool) {
		this.teacherSchool = teacherSchool;
	}
	/**
	 * 获取：讲师所在学校
	 */
	public String getTeacherSchool() {
		return teacherSchool;
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
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}

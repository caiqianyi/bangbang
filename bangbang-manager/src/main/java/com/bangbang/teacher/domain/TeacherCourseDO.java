package com.bangbang.teacher.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 讲师课程中间表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 11:54:01
 */
public class TeacherCourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//讲师编号
	private Long teacherId;
	//课程编号
	private Long courseId;
	//添加世家
	private Date addTime;
	//更新时间
	private Date updateTime;

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
	 * 设置：课程编号
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程编号
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：添加世家
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加世家
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
}

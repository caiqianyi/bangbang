package com.bangbang.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 课程分类列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public class CourseSortDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//课程分类名称
	private String sortName;
	//添加时间
	private Date addTime;
	//状态 0：是；1：否
	private Integer status;
	//排序
	private Integer sortNum;

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
	 * 设置：课程分类名称
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	/**
	 * 获取：课程分类名称
	 */
	public String getSortName() {
		return sortName;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	
	
}

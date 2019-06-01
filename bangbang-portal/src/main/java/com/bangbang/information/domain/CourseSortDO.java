package com.bangbang.information.domain;

import java.io.Serializable;



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
}

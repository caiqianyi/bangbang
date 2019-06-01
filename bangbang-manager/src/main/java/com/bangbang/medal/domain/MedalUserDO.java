package com.bangbang.medal.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户勋章中间表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-30 16:46:50
 */
public class MedalUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户Id
	private Long userId;
	//勋章Id
	private Long medalId;
	//获取时间
	private Date addTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户Id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户Id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：勋章Id
	 */
	public void setMedalId(Long medalId) {
		this.medalId = medalId;
	}
	/**
	 * 获取：勋章Id
	 */
	public Long getMedalId() {
		return medalId;
	}
	/**
	 * 设置：获取时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：获取时间
	 */
	public Date getAddTime() {
		return addTime;
	}
}

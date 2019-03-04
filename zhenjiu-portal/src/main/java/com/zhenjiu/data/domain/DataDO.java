package com.zhenjiu.data.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-03-01 14:48:35
 */
public class DataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//治疗时长
	private Integer treatTime;
	
	//治疗时间
	private Date adddate;
	//用户
	private Integer userid;

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
	 * 设置：治疗时长
	 */
	public void setTreatTime(Integer treatTime) {
		this.treatTime = treatTime;
	}
	/**
	 * 获取：治疗时长
	 */
	public Integer getTreatTime() {
		return treatTime;
	}
	
	/**
	 * 设置：治疗时间
	 */
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	/**
	 * 获取：治疗时间
	 */
	public Date getAdddate() {
		return adddate;
	}
	/**
	 * 设置：用户
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户
	 */
	public Integer getUserid() {
		return userid;
	}
}

package com.bangbang.medal.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



/**
 * 勋章表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 10:26:16
 */
public class MedalDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//勋章编号
	private Long medalId;
	//勋章名称
	private String medalName;
	//勋章图像
	private String medalIco;
	//获取条件
	private String gainRequire;
	//勋章类型 0：升级勋章 1：课程勋章
	private Integer medalSort;
	//奖励
	private String reward;
	//状态
	private Integer status;
	//添加时间
	private Date addTime;
	//更新时间
	private Date updateTime;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	
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
	 * 设置：勋章编号
	 */
	public void setMedalId(Long medalId) {
		this.medalId = medalId;
	}
	/**
	 * 获取：勋章编号
	 */
	public Long getMedalId() {
		return medalId;
	}
	/**
	 * 设置：勋章名称
	 */
	public void setMedalName(String medalName) {
		this.medalName = medalName;
	}
	/**
	 * 获取：勋章名称
	 */
	public String getMedalName() {
		return medalName;
	}
	/**
	 * 设置：勋章图像
	 */
	public void setMedalIco(String medalIco) {
		this.medalIco = medalIco;
	}
	/**
	 * 获取：勋章图像
	 */
	public String getMedalIco() {
		return medalIco;
	}
	/**
	 * 设置：获取条件
	 */
	public void setGainRequire(String gainRequire) {
		this.gainRequire = gainRequire;
	}
	/**
	 * 获取：获取条件
	 */
	public String getGainRequire() {
		return gainRequire;
	}
	/**
	 * 设置：勋章类型 0：升级勋章 1：课程勋章
	 */
	public void setMedalSort(Integer medalSort) {
		this.medalSort = medalSort;
	}
	/**
	 * 获取：勋章类型 0：升级勋章 1：课程勋章
	 */
	public Integer getMedalSort() {
		return medalSort;
	}
	/**
	 * 设置：奖励
	 */
	public void setReward(String reward) {
		this.reward = reward;
	}
	/**
	 * 获取：奖励
	 */
	public String getReward() {
		return reward;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
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
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
}

package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 兑换码表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 13:35:00
 */
public class ReedeemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//兑换码
	private String reedeemCode;
	//创建时间
	private Date createTime;
	//创建者id
	private Long createId;
	//创建者姓名
	private String createName;
	
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//0兑换课程   1兑换余额  2兑换优惠券，一次使用   3.兑换优惠券，多次使用
	private Integer reedeemType;
	
	//兑换码是否已经使用
	private Integer ifStop;
	

	
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
	 * 设置：兑换码
	 */
	public void setReedeemCode(String reedeemCode) {
		this.reedeemCode = reedeemCode;
	}
	/**
	 * 获取：兑换码
	 */
	public String getReedeemCode() {
		return reedeemCode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
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
	public Integer getReedeemType() {
		return reedeemType;
	}
	public void setReedeemType(Integer reedeemType) {
		this.reedeemType = reedeemType;
	}
	
	public Integer getIfStop() {
		return ifStop;
	}
	public void setIfStop(Integer ifStop) {
		this.ifStop = ifStop;
	}
	
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
}
package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 优惠券表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 09:40:06
 */
public class CouponDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//优惠券编号
	private Long couponId;
	//优惠券金额
	private Long couponBalance;
	//有效期
	private Integer validity;
	//使用条件
	private String usecondition;
	//发行数量
	private Long couponCount;
	//优惠券名称
	private String countName;
	//创建时间
	private Date createTime;
	//剩余数量
	private Long couponSurplus;
	
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//使用场景  0  问答使用   1课程使用
	private Integer usageScenario;
	//课程编号
	private Long courseId;
	//课程名称
	private String kechengName;

	
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
	 * 设置：优惠券编号
	 */
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：优惠券编号
	 */
	public Long getCouponId() {
		return couponId;
	}
	/**
	 * 设置：优惠券金额
	 */
	public void setCouponBalance(Long couponBalance) {
		this.couponBalance = couponBalance;
	}
	/**
	 * 获取：优惠券金额
	 */
	public Long getCouponBalance() {
		return couponBalance;
	}
	
	/**
	 * 设置：发行数量
	 */
	public void setCouponCount(Long couponCount) {
		this.couponCount = couponCount;
	}
	/**
	 * 获取：发行数量
	 */
	public Long getCouponCount() {
		return couponCount;
	}
	/**
	 * 设置：优惠券名称
	 */
	public void setCountName(String countName) {
		this.countName = countName;
	}
	/**
	 * 获取：优惠券名称
	 */
	public String getCountName() {
		return countName;
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
	 * 设置：剩余数量
	 */
	public void setCouponSurplus(Long couponSurplus) {
		this.couponSurplus = couponSurplus;
	}
	/**
	 * 获取：剩余数量
	 */
	public Long getCouponSurplus() {
		return couponSurplus;
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
	/**
	 * 获取：优惠券有效期
	 */
	public Integer getValidity() {
		return validity;
	}
	
	/**
	 * 设置：优惠券有效期
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	/**
	 * 获取：使用条件
	 */
	public String getUsecondition() {
		return usecondition;
	}
	/**
	 * 设置：使用条件
	 */
	public void setUsecondition(String usecondition) {
		this.usecondition = usecondition;
	}
	
	/**
	 * 获取：使用场景
	 */
	public Integer getUsageScenario() {
		return usageScenario;
	}
	/**
	 * 设置：使用场景
	 */
	public void setUsageScenario(Integer usageScenario) {
		this.usageScenario = usageScenario;
	}
	/**
	 * 获取：课程编号
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：课程编号
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * 获取 ：课程名称
	 */
	public String getKechengName() {
		return kechengName;
	}
	
	/**
	 * 设置 ：课程名称
	 */
	public void setKechengName(String kechengName) {
		this.kechengName = kechengName;
	}
}

package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 18:42:45
 */
public class LeaveMessageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//课程编号
	private Integer courseId;
	//发表时间
	private Date publishTime;
	//具体内容
	private String leaveText;
	//查看次数
	private Long count;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//课程名
	private String courseName;
	//章节名
	private String chaptersName;
	//用户名
	private String userName;
	//留言的显示和隐藏(0显示   1隐藏)
	private Integer showhide;

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
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：课程编号
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程编号
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：发表时间
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：发表时间
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * 设置：具体内容
	 */
	public void setLeaveText(String leaveText) {
		this.leaveText = leaveText;
	}
	/**
	 * 获取：具体内容
	 */
	public String getLeaveText() {
		return leaveText;
	}
	/**
	 * 设置：查看次数
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	/**
	 * 获取：查看次数
	 */
	public Long getCount() {
		return count;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getShowhide() {
		return showhide;
	}
	public void setShowhide(Integer showhide) {
		this.showhide = showhide;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getChaptersName() {
		return chaptersName;
	}
	public void setChaptersNname(String chaptersName) {
		this.chaptersName = chaptersName;
	}
	
}

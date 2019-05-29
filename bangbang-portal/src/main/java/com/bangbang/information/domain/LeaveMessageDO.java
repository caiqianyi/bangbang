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
	//章节id
	private Integer chapterId;
	//课程名
	private String name;
	//章节名
	private String chapterName;
	//课程封面
	private String courseCover;
	//发表时间
	private Date publishTime;
	//具体内容
	private String leaveText;
	//回复内容
	private String answerText;
	//回复时间
	private Date answerTime;
	//查看次数
	private Long count;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//留言的显示和隐藏(0显示   1隐藏)
	private Integer showhide;
	//留言是否公开  0公开  1隐私
	private Integer ifprivate;
	//留言是否回复 0已回复  1未回复
	private Integer ifanswer;

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
	public Integer getShowhide() {
		return showhide;
	}
	public void setShowhide(Integer showhide) {
		this.showhide = showhide;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIfprivate() {
		return ifprivate;
	}
	public void setIfprivate(Integer ifprivate) {
		this.ifprivate = ifprivate;
	}
	public Integer getIfanswer() {
		return ifanswer;
	}
	public void setIfanswer(Integer ifanswer) {
		this.ifanswer = ifanswer;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getCourseCover() {
		return courseCover;
	}
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
	}
	
}

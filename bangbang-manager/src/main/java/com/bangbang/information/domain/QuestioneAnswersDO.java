package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 问答表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 19:00:44
 */
public class QuestioneAnswersDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//用户id
	private Long userId;
	//用户姓名
	private String userName;
	//讲师姓名
	private String teacherName;
	//问答内容
	private String questionsContent;
	//金额
	private Integer questionsMoney;
	//回复内容
	private String replyContent;
	//课程名称
	private String courseName;
	//添加时间
	private Date addTime;
	//回复时间
	private Date replyTime;

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
	 * 设置：用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：讲师姓名
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 获取：讲师姓名
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * 设置：问答内容
	 */
	public void setQuestionsContent(String questionsContent) {
		this.questionsContent = questionsContent;
	}
	/**
	 * 获取：问答内容
	 */
	public String getQuestionsContent() {
		return questionsContent;
	}
	/**
	 * 设置：金额
	 */
	public void setQuestionsMoney(Integer questionsMoney) {
		this.questionsMoney = questionsMoney;
	}
	/**
	 * 获取：金额
	 */
	public Integer getQuestionsMoney() {
		return questionsMoney;
	}
	/**
	 * 设置：回复内容
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * 获取：回复内容
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
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
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}

package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 问答表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-24 11:12:09
 */
public class QuestioneAnswersDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//用户Id
	private Integer userId;
	//课程Id
	private Integer courseId;
	//问答内容
	private String questionsContent;
	//金额
	private Integer questionsMoney;
	//回复内容
	private String replyContent;
	//添加时间
	private Date addTime;
	//回复时间
	private Date replyTime;
	//课程名
	private String courseName;
	//问答老师
	private String questionsTeacher;
	//用户姓名
	private String userName;
	//0已回复  1未回复
	private Integer ifreply;

	public Integer getIfreply() {
		return ifreply;
	}
	public void setIfreply(Integer ifreply) {
		this.ifreply = ifreply;
	}
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
	 * 设置：用户Id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户Id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：课程Id
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程Id
	 */
	public Integer getCourseId() {
		return courseId;
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
	 * 设置：回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	/**
	 * 获取：回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getQuestionsTeacher() {
		return questionsTeacher;
	}
	public void setQuestionsTeacher(String questionsTeacher) {
		this.questionsTeacher = questionsTeacher;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

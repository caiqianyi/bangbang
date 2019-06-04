package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



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
	private Long id;
	//用户Id
	private Long userId;
	//课程编号
	private Long courseId;
	//问答老师id
	private Long teacherId;
	//问答内容
	private String questionsContent;
	//回复内容
	private String replyContent;
	//问答金额
	private Double questionsMoney;
	//添加时间
	private Date addTime;
	//回复时间
	private Date replyTime;
	
	//问答老师
	private String questionsTeacher;
	//课程名
	private String name;
	//0已回复  1未回复
	private Integer ifreply;
	//课程封面
	private String courseCover;
	//问答图片
	private MultipartFile[] askimgs;

	
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
	 * 设置：课程Id
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程Id
	 */
	public Long getCourseId() {
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
	public String getQuestionsTeacher() {
		return questionsTeacher;
	}
	public void setQuestionsTeacher(String questionsTeacher) {
		this.questionsTeacher = questionsTeacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIfreply() {
		return ifreply;
	}
	public void setIfreply(Integer ifreply) {
		this.ifreply = ifreply;
	}
	public String getCourseCover() {
		return courseCover;
	}
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
	}
	public MultipartFile[] getAskimgs() {
		return askimgs;
	}
	public void setAskimgs(MultipartFile[] askimgs) {
		this.askimgs = askimgs;
	}
	public Double getQuestionsMoney() {
		return questionsMoney;
	}
	public void setQuestionsMoney(Double questionsMoney) {
		this.questionsMoney = questionsMoney;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
}

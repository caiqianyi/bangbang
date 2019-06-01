package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



/**
 * 课程表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//课程编号
	private Long courseId;
	//课程分类
	private String courseName;
	//课程分类id
	private Long sortId;
	//课程名称
	private String name;
	//课程说明
	private String courseNotes;
	//是否收费  0：是 1:否
	private Integer moneyType;
	//课程价格
	private Double money;
	//是否开启问答 0：是 1：否
	private Integer questions;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//课程封面
	private String courseCover;
	//讲师
	private String teacher;
	//问答讲师
	private String questionsTeacher;
	//章节个数
	private Integer chapterNum;
	//课程是否已购买   0已购买   1未购买
	private Integer ifNBuy;
	//播放次数
	private Integer playTimes;
	
	
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
	 * 设置：课程编号
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程编号
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * 设置：课程名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：课程名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：是否收费  0：是 1:否
	 */
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
	/**
	 * 获取：是否收费  0：是 1:否
	 */
	public Integer getMoneyType() {
		return moneyType;
	}
	public String getCourseNotes() {
		return courseNotes;
	}
	public void setCourseNotes(String courseNotes) {
		this.courseNotes = courseNotes;
	}
	/**
	 * 设置：课程价格
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * 获取：课程价格
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * 设置：是否开启问答 0：是 1：否
	 */
	public void setQuestions(Integer questions) {
		this.questions = questions;
	}
	/**
	 * 获取：是否开启问答 0：是 1：否
	 */
	public Integer getQuestions() {
		return questions;
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
	public String getCourseCover() {
		return courseCover;
	}
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getQuestionsTeacher() {
		return questionsTeacher;
	}
	public void setQuestionsTeacher(String questionsTeacher) {
		this.questionsTeacher = questionsTeacher;
	}
	public Integer getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(Integer chapterNum) {
		this.chapterNum = chapterNum;
	}
	public Long getSortId() {
		return sortId;
	}
	public void setSortId(Long sortId) {
		this.sortId = sortId;
	}
	public Integer getIfNBuy() {
		return ifNBuy;
	}
	public void setIfNBuy(Integer ifNBuy) {
		this.ifNBuy = ifNBuy;
	}
	public Integer getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}

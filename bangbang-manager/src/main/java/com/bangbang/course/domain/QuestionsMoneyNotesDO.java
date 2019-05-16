package com.bangbang.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 课程问答金额和说明表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public class QuestionsMoneyNotesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//课程分类
	private String courseSort;
	//课程编号
	private Long courseId;
	//课程名称
	private String name;
	//问答金额1
	private Integer questionsMoney1;
	//问答金额2
	private Integer questionsMoney2;
	//问答金额3
	private Integer questionsMoney3;
	//问答说明1
	private String questionsNotes1;
	//问答说明2
	private String questionsNotes2;
	//问答说明3
	private String questionsNotes3;
	//添加时间
	private Date addTime;
	//更新时间
	private Date updateTime;

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
	 * 设置：课程分类
	 */
	public void setCourseSort(String courseSort) {
		this.courseSort = courseSort;
	}
	/**
	 * 获取：课程分类
	 */
	public String getCourseSort() {
		return courseSort;
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
	 * 设置：问答金额1
	 */
	public void setQuestionsMoney1(Integer questionsMoney1) {
		this.questionsMoney1 = questionsMoney1;
	}
	/**
	 * 获取：问答金额1
	 */
	public Integer getQuestionsMoney1() {
		return questionsMoney1;
	}
	/**
	 * 设置：问答金额2
	 */
	public void setQuestionsMoney2(Integer questionsMoney2) {
		this.questionsMoney2 = questionsMoney2;
	}
	/**
	 * 获取：问答金额2
	 */
	public Integer getQuestionsMoney2() {
		return questionsMoney2;
	}
	/**
	 * 设置：问答金额3
	 */
	public void setQuestionsMoney3(Integer questionsMoney3) {
		this.questionsMoney3 = questionsMoney3;
	}
	/**
	 * 获取：问答金额3
	 */
	public Integer getQuestionsMoney3() {
		return questionsMoney3;
	}
	/**
	 * 设置：问答说明1
	 */
	public void setQuestionsNotes1(String questionsNotes1) {
		this.questionsNotes1 = questionsNotes1;
	}
	/**
	 * 获取：问答说明1
	 */
	public String getQuestionsNotes1() {
		return questionsNotes1;
	}
	/**
	 * 设置：问答说明2
	 */
	public void setQuestionsNotes2(String questionsNotes2) {
		this.questionsNotes2 = questionsNotes2;
	}
	/**
	 * 获取：问答说明2
	 */
	public String getQuestionsNotes2() {
		return questionsNotes2;
	}
	/**
	 * 设置：问答说明3
	 */
	public void setQuestionsNotes3(String questionsNotes3) {
		this.questionsNotes3 = questionsNotes3;
	}
	/**
	 * 获取：问答说明3
	 */
	public String getQuestionsNotes3() {
		return questionsNotes3;
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
}

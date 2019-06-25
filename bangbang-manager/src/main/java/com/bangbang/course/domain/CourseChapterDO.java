package com.bangbang.course.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;



/**
 * 课程章节
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public class CourseChapterDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Long id;
	//父菜单ID，一级菜单为0
	private Long parentId;
	//课程编号
	private Long courseId;
	//课程分类
	private String courseName;
	//课程名称
	private String name;
	//章节序号
	private Integer chapterNum;
	//章节名称
	private String chapterName;
	//章节说明
	private String chapterNotes;
	//类型 0：章节 1：小节
	private Integer type;
	//课程url
	private String url;
	//章节状态 0：解锁 1：限制
	private Integer chapterStatus;
	//添加时间
	private Date addTime;
	//开始时间
	private Date startTime;
	//结束时间
	private Date endTime;
	//文件时长
	private String duration;
	
	private MultipartFile imgFile;
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
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
	 * 设置：父菜单ID，一级菜单为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父菜单ID，一级菜单为0
	 */
	public Long getParentId() {
		return parentId;
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
	 * 设置：课程分类
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程分类
	 */
	public String getCourseName() {
		return courseName;
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
	 * 设置：章节id
	 */
	public void setChapterNum(Integer chapterNum) {
		this.chapterNum = chapterNum;
	}
	/**
	 * 获取：章节id
	 */
	public Integer getChapterNum() {
		return chapterNum;
	}
	/**
	 * 设置：章节名称
	 */
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	/**
	 * 获取：章节名称
	 */
	public String getChapterName() {
		return chapterName;
	}
	/**
	 * 设置：章节说明
	 */
	public void setChapterNotes(String chapterNotes) {
		this.chapterNotes = chapterNotes;
	}
	/**
	 * 获取：章节说明
	 */
	public String getChapterNotes() {
		return chapterNotes;
	}
	/**
	 * 设置：类型 0：章节 1：小节
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型 0：章节 1：小节
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：课程url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：课程url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：章节状态 0：解锁 1：限制
	 */
	public void setChapterStatus(Integer chapterStatus) {
		this.chapterStatus = chapterStatus;
	}
	/**
	 * 获取：章节状态 0：解锁 1：限制
	 */
	public Integer getChapterStatus() {
		return chapterStatus;
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

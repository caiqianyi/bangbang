package com.bangbang.information.domain;

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
	//课程url
	private String url;
	//章节的播放时间
	private String duration;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}

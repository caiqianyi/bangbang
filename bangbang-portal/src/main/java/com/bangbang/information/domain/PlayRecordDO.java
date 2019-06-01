package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 播放记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 15:51:59
 */
public class PlayRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//课程编号
	private Integer courseId;
	//课程分类
	private String courseName;
	//课程名称
	private String name;
	//章节id
	private Long characterId;
	//章节名称
	private String chapterName;
	//上次播放时间
	private Date playedTime;

	//用户id
	private Long userId;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;
	//章节个数
	private Integer chapterNum;
	//课程封面
	private String courseCover;
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
	 * 设置：上次播放时间
	 */
	public void setPlayedTime(Date playedTime) {
		this.playedTime = playedTime;
	}
	/**
	 * 获取：上次播放时间
	 */
	public Date getPlayedTime() {
		return playedTime;
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
	public Long getCharacterId() {
		return characterId;
	}
	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}
	public Integer getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(Integer chapterNum) {
		this.chapterNum = chapterNum;
	}
	public String getCourseCover() {
		return courseCover;
	}
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
	}
	
	
}

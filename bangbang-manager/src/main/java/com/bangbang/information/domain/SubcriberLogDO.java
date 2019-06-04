package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 购买转发收藏表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 14:01:30
 */
public class SubcriberLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//课程编号
	private Integer courseId;
	//课程分类
	private String courseName;
	//课程名称
	private String name;
	//购买时间
	private Date updateTime;
	//用户id
	private Long userId;
	//状态 0：是 1 :否
	private Integer status;
	//0 购买  1  转发  2收藏
	private Integer flag;
	//收藏的章节id
	private Long chapterId;
    //收藏的章节名称
	private String chapterName;
	//删除标志  0 未删除   1已删除
	private Integer deleteFlag;

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
	 * 设置：操作时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	 * 设置：状态 0：是 1 :否
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0：是 1 :否
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：0 购买  1  转发  2收藏
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：0 购买  1  转发  2收藏
	 */
	public Integer getFlag() {
		return flag;
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
	public Long getChapterId() {
		return chapterId;
	}
	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
}

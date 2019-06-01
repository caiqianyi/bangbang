package com.bangbang.information.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-30 11:24:24
 */
public class QuestioneAnswersImageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//问答Id
	private Long questionAnswersId;
	//问答图片
	private String picImg;
	//排序
	private Integer sort;
	//状态(0:用户1：老师)
	private Integer status;

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
	 * 设置：问答Id
	 */
	public void setQuestionAnswersId(Long questionAnswersId) {
		this.questionAnswersId = questionAnswersId;
	}
	/**
	 * 获取：问答Id
	 */
	public Long getQuestionAnswersId() {
		return questionAnswersId;
	}
	/**
	 * 设置：问答图片
	 */
	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}
	/**
	 * 获取：问答图片
	 */
	public String getPicImg() {
		return picImg;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
}

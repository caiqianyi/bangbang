package com.bangbang.information.domain;
public class ChartData {
	private Long userId;
	private String str;
	private Long sumPlayedTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSumPlayedTime() {
		return sumPlayedTime;
	}
	public void setSumPlayedTime(Long sumPlayedTime) {
		this.sumPlayedTime = sumPlayedTime;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}

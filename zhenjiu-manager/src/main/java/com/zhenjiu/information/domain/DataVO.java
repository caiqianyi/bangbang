package com.zhenjiu.information.domain;

import java.util.Date;

public class DataVO {
	private Date startTime;
	private Date endTime;
	
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "DataVO [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
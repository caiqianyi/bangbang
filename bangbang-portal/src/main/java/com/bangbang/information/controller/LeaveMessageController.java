package com.bangbang.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangbang.common.annotation.Log;
import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.LeaveMessageService;
import com.bangbang.information.service.SubscriberService;

@RestController
@RequestMapping("/bangbang/leavemessage")
public class LeaveMessageController { 
	@Autowired
	private LeaveMessageService leaveMessageService;
	@Autowired
	private SubscriberService subscriberService;
	
	/**
	 * 留言新增
	 */
	
	@Log("留言新增接口")
	@RequestMapping("/saveLeaveMessage")
	public Map<String,Object> saveLeaveMessage(LeaveMessageDO leaveMessageDO){
		leaveMessageDO.setPublishTime(new Date());
		leaveMessageDO.setShowhide(0);
		leaveMessageDO.setIfanswer(1);
		int result = leaveMessageService.saveLeaveMessage(leaveMessageDO);

		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0)
			map.put("msg","留言保存成功");
		else
			map.put("msg","留言保存失败");
		return map;
	}

	/**
	 * 获取我的留言
	 */
	
	@Log("获取我的留言接口")
	@RequestMapping("/getAllLeaveMessage")
	public Map<String,Object> getAllLeaveMessage(String phone){
		Map<String,Object> map = new HashMap<String,Object>();
		SubscriberDO subscriberDO = subscriberService.getInfo(phone);
		map.put("subscriber", subscriberDO);
		List<LeaveMessageDO> list= leaveMessageService.getAllLeaveMessage(subscriberDO.getId());
		map.put("leaveMessage", list);
		List<QuestioneAnswersDO> list1=leaveMessageService.getAllQuestioneAnswers(subscriberDO.getId());
		map.put("questioneAnswers", list1);
		return map;
	}
}

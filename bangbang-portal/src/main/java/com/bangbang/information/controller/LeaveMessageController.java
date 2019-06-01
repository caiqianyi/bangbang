package com.bangbang.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	/**
	 * 留言新增
	 */
	
	@Log("留言新增接口")
	@PostMapping("/saveLeaveMessage")
	public Map<String,Object> saveLeaveMessage(LeaveMessageDO leaveMessageDO){
		leaveMessageDO.setPublishTime(new Date());
		leaveMessageDO.setShowhide(0);
		leaveMessageDO.setIfanswer(1);
		leaveMessageDO.setCount(0l);
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
	@GetMapping("/getAllLeaveMessage")
	public Map<String,Object> getAllLeaveMessage(Long userId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<LeaveMessageDO> list= leaveMessageService.getAllLeaveMessage(userId);
		if(list.size()==0){
			map.put("code", 1);
			map.put("msg","没有留言");
			map.put("data", list);
		}
		else{
			map.put("code",0);
			map.put("msg","");
			map.put("data", list);
		}
		return map;
	}
	
	/**
	 * 获取我的问答
	 */
	
	@Log("获取我的问答接口")
	@GetMapping("/getAllWenda")
	public Map<String,Object> getAllWenda(Long userId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<QuestioneAnswersDO> list= leaveMessageService.getAllQuestioneAnswers(userId);
		if(list.size()==0){
			map.put("code", 1);
			map.put("msg","没有问答");
			map.put("data", list);
		}
		else{
			map.put("code",0);
			map.put("msg","");
			map.put("data", list);
		}
		return map;
	}
}

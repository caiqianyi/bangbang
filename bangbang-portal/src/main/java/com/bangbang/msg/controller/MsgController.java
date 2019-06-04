package com.bangbang.msg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.controller.BaseController;
import com.bangbang.msg.domain.MsgDO;
import com.bangbang.msg.service.MsgService;



/**
 * 消息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-21 17:28:29
 */
 
@Controller
@RequestMapping("/bangbang/msg")
public class MsgController extends BaseController{
	@Autowired
	private MsgService msgService;

	/*
	 * 消息列表
	 */
	@ResponseBody
	@GetMapping("/list")
	public Map<String, Object> list(){
		//查询列表数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<MsgDO> msgList = msgService.queryMsgList(getUserId());
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", msgList);
		return map;
	}
	
	/*
	 * 消息详情
	 */
	@ResponseBody
	@GetMapping("/info")
	Map<String, Object> info(Long id,Long muId){
		Map<String, Object> map = new HashMap<String, Object>();
		MsgDO msgDO = msgService.queryMsgDetails(id, muId);
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", msgDO);
	    return map;
	}
	

}

package com.zhenjiu.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenjiu.common.annotation.Log;
import com.zhenjiu.common.controller.BaseController;
import com.zhenjiu.information.domain.MsgDO;
import com.zhenjiu.information.service.MsgService;


/**
 * 消息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-19 11:33:19
 */
 
@Controller
@RequestMapping("/msg")
public class MsgController extends BaseController{
	@Autowired
	private MsgService msgService;
	
	
	@Log("获取信息列表")
	@ResponseBody
	@GetMapping("/list")
	 Map<String, Object> list(Model model){
		Map<String, Object> map = new HashMap<>();
		List<Map<Object, String>> userMsgList = msgService.queryUserMsgList(getUserId());
		MsgDO msgDO = new MsgDO();
		if(msgDO.getForIds() != null){
			userMsgList = msgService.queryUserMsgList(getUserId());
		}
		if(msgDO.getForIds() == null){
			userMsgList = msgService.queryUserMsgListNull(map);
		}
		map.put("userMsgList", userMsgList);
		return map;
	}
	
	
	@Log("信息详情")
	@ResponseBody
	@GetMapping("/list/info/{id}")
	Map<String, Object> info(Model model,@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<>();
		MsgDO userMsgId = msgService.queryUserMsgId(id,getUserId());
		map.put("userMsgId", userMsgId);
		return map;
	}
	
}

package com.dingshi.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dingshi.common.annotation.Log;
import com.dingshi.common.domain.LogDO;
import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
import com.dingshi.common.utils.R;
import com.dingshi.common.utils.StringUtils;
import com.dingshi.information.domain.ConsultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dingshi.common.controller.BaseController;
import com.dingshi.information.service.ConsultService;

/**
 * 交易表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-04-13 14:42:52
 */
 
@RestController
@RequestMapping("/information/consult")
public class ConsultController extends BaseController{
	@Autowired
	private ConsultService consultService;

	
	@Log("消息列表")
	@GetMapping("/msgList")
	Map<String, Object> msgList(@RequestParam Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		params.put("deleteFlag", 1);
		Query query = new Query(params);
		PageDO<ConsultDO> page = consultService.list(query);
		map.put("msg",page);
		return map;
	}
	@Log("阅读消息")
	@PostMapping("/editMsg")
	Map<String, Object>  editMsg(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		ConsultDO consult = consultService.get(id);
		if(consult!=null){
			int num = consult.getBrowseNum() == null ? 0 : consult.getBrowseNum();
			consult.setBrowseNum(num + 1);
			consultService.update(consult);
		}
		map.put("msg","success");
		return map;
	}
}

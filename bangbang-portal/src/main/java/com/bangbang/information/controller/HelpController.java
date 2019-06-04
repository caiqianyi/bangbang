package com.bangbang.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.HelpDO;
import com.bangbang.information.service.HelpService;


/**
 * 帮助表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 15:45:34
 */
 
@Controller
@RequestMapping("/bangbang/help")
public class HelpController {
	@Autowired
	private HelpService helpService;

	/*
	 * 帮助中心
	 */
	@ResponseBody
	@GetMapping("/list")
	public Map<String, Object> list(){
		//查询列表数据
		Map<String, Object> map = new HashMap<String, Object>();
		List<HelpDO> helpList = helpService.list(map);
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", helpList);
		return map;
	}
	
	
}

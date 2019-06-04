package com.bangbang.medal.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.controller.BaseController;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.medal.domain.MedalDO;
import com.bangbang.medal.domain.MedalUserDO;
import com.bangbang.medal.service.MedalService;
import com.bangbang.medal.service.MedalUserService;
import com.bangbang.owneruser.comment.GenerateCode;


/**
 * 勋章表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 10:26:16
 */
 
@Controller
@RequestMapping("/bangbang/medal")
public class MedalController  extends BaseController{
	@Autowired
	private MedalService medalService;
	@Autowired
	private MedalUserService medalUserService;
	
	/*
	 * 我的勋章
	 */
	@ResponseBody
	@GetMapping("/medalList")
	public Map<String, Object> medalList(Long userId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<MedalDO> list = medalService.list(map);
		for (MedalDO medalDO : list) {
			medalDO.setUserMedal(1);
			Long medalId2 = medalDO.getMedalId();
			List<MedalUserDO> medalUserList = medalUserService.medalUserList(userId);
			for (MedalUserDO medalUserDO : medalUserList) {
				Long medalId = medalUserDO.getMedalId();
				if(medalId.equals(medalId2)){
					medalDO.setUserMedal(0);
				}
			}
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);	
					
		return map;
	}
	
	
}

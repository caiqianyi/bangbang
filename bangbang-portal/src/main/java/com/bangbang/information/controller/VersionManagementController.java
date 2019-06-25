package com.bangbang.information.controller;


import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.bangbang.information.domain.VersionManagementDO;
import com.bangbang.information.service.VersionManagementService;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-04-16 09:53:33
 */
 
@RestController
@RequestMapping("/bangbang/versionManagement")
public class VersionManagementController {
	@Autowired
	private VersionManagementService versionManagementService;
	
	

	@GetMapping("/getNewAppVersion")//手机系统，版本号
	Map<String,Object> getNewAppVersion(VersionManagementDO versionManagementDO){
		VersionManagementDO versionManagement = versionManagementService.get(versionManagementDO.getPhoneSystem());
		Map<String,Object> map = new HashMap<String,Object>();
		if(versionManagement!=null){
			if(versionManagement.getAppNum().compareTo(versionManagementDO.getAppNum())>0){//App版本需要更新
				map.put("code", 0);
				map.put("msg","出现更高版本App");
				map.put("data", versionManagement);
			}
			else{
				map.put("code", 1);
				map.put("msg","当前App已是最高版本");
	//			map.put("data", versionManagement);
			}
		}
		return map;
	}
	
}

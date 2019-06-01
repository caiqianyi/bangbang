package com.bangbang.information.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.VersionManagementDO;
import com.bangbang.information.service.VersionManagementService;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-04-16 09:53:33
 */
 
@Controller
@RequestMapping("/information/versionManagement")
public class VersionManagementController {
	@Autowired
	private VersionManagementService versionManagementService;
	
	@GetMapping()
	@RequiresPermissions("information:versionManagement:versionManagement")
	String VersionManagement(){
	    return "information/versionManagement/versionManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:versionManagement:versionManagement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<VersionManagementDO> versionManagementList = versionManagementService.list(query);
		int total = versionManagementService.count(query);
		PageUtils pageUtils = new PageUtils(versionManagementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:versionManagement:add")
	String add(){
	    return "information/versionManagement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:versionManagement:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		VersionManagementDO versionManagement = versionManagementService.get(id);
		model.addAttribute("versionManagement", versionManagement);
	    return "information/versionManagement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:versionManagement:add")
	public R save( VersionManagementDO versionManagement){
		versionManagement.setAppUpdateTime(new Date());
		if(versionManagementService.save(versionManagement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:versionManagement:edit")
	public R update( VersionManagementDO versionManagement){
		versionManagementService.update(versionManagement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:versionManagement:remove")
	public R remove( Integer id){
		if(versionManagementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:versionManagement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		versionManagementService.batchRemove(ids);
		return R.ok();
	}
	
}

package com.bangbang.information.controller;

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
import com.bangbang.information.domain.RegisterAgreementDO;
import com.bangbang.information.service.RegisterAgreementService;


/**
 * 注册协议
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 16:50:53
 */
 
@Controller
@RequestMapping("/information/registerAgreement")
public class RegisterAgreementController {
	@Autowired
	private RegisterAgreementService registerAgreementService;
	
	@GetMapping()
	@RequiresPermissions("information:registerAgreement:registerAgreement")
	String RegisterAgreement(){
	    return "information/registerAgreement/registerAgreement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:registerAgreement:registerAgreement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RegisterAgreementDO> registerAgreementList = registerAgreementService.list(query);
		int total = registerAgreementService.count(query);
		PageUtils pageUtils = new PageUtils(registerAgreementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:registerAgreement:add")
	String add(){
	    return "information/registerAgreement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:registerAgreement:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		RegisterAgreementDO registerAgreement = registerAgreementService.get(id);
		model.addAttribute("registerAgreement", registerAgreement);
	    return "information/registerAgreement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:registerAgreement:add")
	public R save( RegisterAgreementDO registerAgreement){
		if(registerAgreementService.save(registerAgreement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:registerAgreement:edit")
	public R update( RegisterAgreementDO registerAgreement){
		registerAgreementService.update(registerAgreement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:registerAgreement:remove")
	public R remove( Integer id){
		if(registerAgreementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:registerAgreement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		registerAgreementService.batchRemove(ids);
		return R.ok();
	}
	
}

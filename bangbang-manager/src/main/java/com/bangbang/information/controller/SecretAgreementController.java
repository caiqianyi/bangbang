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
import com.bangbang.information.domain.SecretAgreementDO;
import com.bangbang.information.service.SecretAgreementService;



/**
 * 隐私协议
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 16:50:53
 */
 
@Controller
@RequestMapping("/information/secretAgreement")
public class SecretAgreementController {
	@Autowired
	private SecretAgreementService secretAgreementService;
	
	@GetMapping()
	@RequiresPermissions("information:secretAgreement:secretAgreement")
	String SecretAgreement(){
	    return "information/secretAgreement/secretAgreement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:secretAgreement:secretAgreement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SecretAgreementDO> secretAgreementList = secretAgreementService.list(query);
		int total = secretAgreementService.count(query);
		PageUtils pageUtils = new PageUtils(secretAgreementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:secretAgreement:add")
	String add(){
	    return "information/secretAgreement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:secretAgreement:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SecretAgreementDO secretAgreement = secretAgreementService.get(id);
		model.addAttribute("secretAgreement", secretAgreement);
	    return "information/secretAgreement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:secretAgreement:add")
	public R save( SecretAgreementDO secretAgreement){
		if(secretAgreementService.save(secretAgreement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:secretAgreement:edit")
	public R update( SecretAgreementDO secretAgreement){
		secretAgreementService.update(secretAgreement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:secretAgreement:remove")
	public R remove( Integer id){
		if(secretAgreementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:secretAgreement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		secretAgreementService.batchRemove(ids);
		return R.ok();
	}
	
}

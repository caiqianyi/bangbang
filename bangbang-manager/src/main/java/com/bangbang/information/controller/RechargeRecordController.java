package com.bangbang.information.controller;

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
import com.bangbang.information.domain.RechargeRecordDO;
import com.bangbang.information.service.RechargeRecordService;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 17:38:48
 */
 
@Controller
@RequestMapping("/information/rechargeRecord")
public class RechargeRecordController {
	@Autowired
	private RechargeRecordService rechargeRecordService;
	
	@GetMapping()
	@RequiresPermissions("information:rechargeRecord:rechargeRecord")
	String RechargeRecord(){
	    return "information/rechargeRecord/rechargeRecord";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:rechargeRecord:rechargeRecord")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RechargeRecordDO> rechargeRecordList = rechargeRecordService.list(query);
		int total = rechargeRecordService.count(query);
		PageUtils pageUtils = new PageUtils(rechargeRecordList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:rechargeRecord:add")
	String add(){
	    return "information/rechargeRecord/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:rechargeRecord:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		RechargeRecordDO rechargeRecord = rechargeRecordService.get(id);
		model.addAttribute("rechargeRecord", rechargeRecord);
	    return "information/rechargeRecord/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:rechargeRecord:add")
	public R save( RechargeRecordDO rechargeRecord){
		if(rechargeRecordService.save(rechargeRecord)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:rechargeRecord:edit")
	public R update( RechargeRecordDO rechargeRecord){
		rechargeRecordService.update(rechargeRecord);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:rechargeRecord:remove")
	public R remove( Integer id){
		if(rechargeRecordService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:rechargeRecord:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		rechargeRecordService.batchRemove(ids);
		return R.ok();
	}
	
}

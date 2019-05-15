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
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.service.PlayRecordService;



/**
 * 播放记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 15:51:59
 */
 
@Controller
@RequestMapping("/information/record")
public class PlayRecordController {
	@Autowired
	private PlayRecordService recordService;
	
	@GetMapping("/{id}")
	@RequiresPermissions("information:record:record")
	String Record(@PathVariable("id") Integer id,Model model){
		model.addAttribute("userId",id);
	    return "information/playrecord/record";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:record:record")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PlayRecordDO> recordList = recordService.list(query);
		int total = recordService.count(query);
		PageUtils pageUtils = new PageUtils(recordList, total);
		return pageUtils;
	}
	
	/*@GetMapping("/add")
	@RequiresPermissions("information:record:add")
	String add(){
	    return "information/record/add";
	}*/

	/*@GetMapping("/edit/{id}")
	@RequiresPermissions("information:record:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PlayRecordDO record = recordService.get(id);
		model.addAttribute("record", record);
	    return "information/record/edit";
	}*/
	
	/**
	 * 保存
	 *//*
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:record:add")
	public R save( PlayRecordDO record){
		if(recordService.save(record)>0){
			return R.ok();
		}
		return R.error();
	}*/
	/**
	 * 修改
	 */
	/*@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:record:edit")
	public R update( PlayRecordDO record){
		recordService.update(record);
		return R.ok();
	}
	*/
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:record:remove")
	public R remove( Integer id){
		if(recordService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	/*@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:record:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		recordService.batchRemove(ids);
		return R.ok();
	}
	*/
}

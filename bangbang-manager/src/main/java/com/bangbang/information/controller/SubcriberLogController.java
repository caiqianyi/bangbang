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
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.service.SubcriberLogService;



/**
 * 购买转发收藏表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 14:01:30
 */
 
@Controller
@RequestMapping("/information/subcriberlog")
public class SubcriberLogController {
	@Autowired
	private SubcriberLogService logService;
	
	@GetMapping("/{flag}/{id}")
	@RequiresPermissions("information:subcriberlog:log")
	String Log(@PathVariable("flag") Integer flag,@PathVariable("id") Integer id,Model model){
		model.addAttribute("flag", flag);//0购买  1转发  2收藏
		model.addAttribute("userId", id);
	    return "information/subcriberlog/log";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:subcriberlog:log")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubcriberLogDO> logList = logService.list(query);
		int total = logService.count(query);
		PageUtils pageUtils = new PageUtils(logList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:subcriberlog:add")
	String add(){
	    return "information/subcriberlog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:subcriberlog:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SubcriberLogDO log = logService.get(id);
		model.addAttribute("log", log);
	    return "information/subcriberlog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:subcriberlog:add")
	public R save( SubcriberLogDO log){
		if(logService.save(log)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:subcriberlog:edit")
	public R update( SubcriberLogDO log){
		logService.update(log);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:subcriberlog:remove")
	public R remove( Integer id){
		if(logService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:subcriberlog:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		logService.batchRemove(ids);
		return R.ok();
	}
	
}

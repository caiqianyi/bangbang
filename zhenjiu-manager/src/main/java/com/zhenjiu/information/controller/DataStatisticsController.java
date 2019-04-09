package com.zhenjiu.information.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenjiu.common.utils.PageUtils;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.information.domain.ConsultDO;
import com.zhenjiu.information.domain.DataDO;
import com.zhenjiu.information.service.DataStatisticsService;

@Controller
@RequestMapping("/information/dataStatis")
public class DataStatisticsController {
	@Autowired
	private DataStatisticsService dataStatisticsService;
	
	@GetMapping()
	@RequiresPermissions("information:dataStatis:dataStatis")
	String Data(){
	    return "information/datastat/data";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:dataStatis:dataStatis")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<DataDO> dataList = dataStatisticsService.list(query);
		System.out.println(dataList);
		int total = dataStatisticsService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/selectByUsername")
	@RequiresPermissions("information:dataStatis:dataStatis")
	public PageUtils selectByUsername(@RequestParam Map<String, Object> params,String name){
		//查询列表数据
		Query query = new Query(params);
		List<DataDO> dataList = dataStatisticsService.selectByUsername(name);
		int total = dataStatisticsService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	
	@GetMapping("/add")
	@RequiresPermissions("information:dataStatis:add")
	String add(){
	    return "information/datastat/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:dataStatis:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DataDO data = dataStatisticsService.get(id);
		model.addAttribute("data", data);
	    return "information/datastat/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:dataStatis:add")
	public R save( DataDO data){
		if(dataStatisticsService.save(data)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:dataStatis:edit")
	public R update( DataDO data){
		dataStatisticsService.update(data);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:dataStatis:remove")
	public R remove( Integer id){
		if(dataStatisticsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:dataStatis:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		dataStatisticsService.batchRemove(ids);
		return R.ok();
	}
	
	
	
}

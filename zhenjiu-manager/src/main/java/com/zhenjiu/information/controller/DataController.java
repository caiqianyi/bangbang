package com.zhenjiu.information.controller;

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

import com.zhenjiu.common.utils.PageUtils;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.information.domain.DataDO;
import com.zhenjiu.information.domain.DataVO;
import com.zhenjiu.information.service.DataService;
import com.zhenjiu.users.domain.UserDO;
import com.zhenjiu.users.service.UserService;


/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-03-29 17:51:43
 */
 
@Controller
@RequestMapping("/information/data")
public class DataController {
	@Autowired
	private DataService dataService;
	@Autowired
	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("information:data:data")
	String Data(){
	    return "information/data/data";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:data:data")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DataDO> dataList = dataService.list(query);
		int total = dataService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/lists/{id}")
	@RequiresPermissions("information:data:data")
	public List<DataDO> lists(@PathVariable("id") Integer id){
		//查询列表数据
		System.out.println(id);
		//Query query = new Query(params);
		List<DataDO> dataList = dataService.lists(id);
		//int total = dataService.count(query);
		//PageUtils pageUtils = new PageUtils(dataList, total);
		return dataList;
	}
	
	@ResponseBody
	@GetMapping("/monthlist")
	@RequiresPermissions("information:data:data")
	public PageUtils monthlist(@RequestParam Map<String, Object> params){
		//按月查询列表数据
        Query query = new Query(params);
		List<DataDO> dataList = dataService.selectByMonth(query);
		int total = dataService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/weeklist")
	@RequiresPermissions("information:data:data")
	public PageUtils weeklist(@RequestParam Map<String, Object> params){
		//按月查询列表数据
        Query query = new Query(params);
		List<DataDO> dataList = dataService.selectByWeek(query);
		int total = dataService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/daylist")
	@RequiresPermissions("information:data:data")
	public PageUtils daylist(@RequestParam Map<String, Object> params){
		//按月查询列表数据
        Query query = new Query(params);
		List<DataDO> dataList = dataService.selectByDay(query);
		int total = dataService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/selectBytime")
	@RequiresPermissions("information:dataStatis:dataStatis")
	public PageUtils selectBytime(@RequestParam Map<String, Object> params,DataVO vo){
		//查询列表数据
		Query query = new Query(params);
		System.out.println(vo);
		List<DataDO> dataList = dataService.selectBytime(vo);
		System.out.println(dataList);
		int total = dataService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	
	
	@GetMapping("/add")
	@RequiresPermissions("information:data:add")
	String add(){
	    return "information/data/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:data:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DataDO data = dataService.get(id);
		model.addAttribute("data", data);
	    return "information/data/edit";
	}
	

	@GetMapping("/show/{id}")
	String show(@PathVariable("id") Integer id,Model model){
		UserDO data = userService.get(id);
		model.addAttribute("data", data);
	    return "information/data/show";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:data:add")
	public R save( DataDO data){
		if(dataService.save(data)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:data:edit")
	public R update( DataDO data){
		dataService.update(data);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:data:remove")
	public R remove( Integer id){
		if(dataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:data:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		dataService.batchRemove(ids);
		return R.ok();
	}
	
}

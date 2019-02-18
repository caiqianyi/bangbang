package com.zhenjiu.device.controller;

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

import com.zhenjiu.common.utils.PageUtils;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.device.domain.DeviceDO;
import com.zhenjiu.device.service.DeviceService;


/**
 * 用户设备表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-18 16:22:42
 */
 
@Controller
@RequestMapping("/information/device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@GetMapping()
	@RequiresPermissions("information:device:device")
	String Device(){
	    return "information/device/device";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:device:device")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DeviceDO> deviceList = deviceService.list(query);
		int total = deviceService.count(query);
		PageUtils pageUtils = new PageUtils(deviceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:device:add")
	String add(){
	    return "information/device/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:device:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DeviceDO device = deviceService.get(id);
		model.addAttribute("device", device);
	    return "information/device/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:device:add")
	public R save( DeviceDO device){
		if(deviceService.save(device)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:device:edit")
	public R update( DeviceDO device){
		deviceService.update(device);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:device:remove")
	public R remove( Integer id){
		if(deviceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:device:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		deviceService.batchRemove(ids);
		return R.ok();
	}
	
}

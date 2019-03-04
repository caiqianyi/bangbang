package com.zhenjiu.device.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenjiu.common.utils.ShiroUtils;
import com.zhenjiu.device.domain.DeviceDO;
import com.zhenjiu.device.service.DeviceService;


/**
 * 用户设备表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-18 16:22:42
 */
 
@RestController
@RequestMapping("/zhenjiu/device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	/**
	 * 设备列表接口
	 */
	@GetMapping("/list")
	Map<String,Object> list(){
	   Map<String,Object> params = new HashMap<String,Object>();
	   params.put("account",ShiroUtils.getUser().getPhone());
	   List<DeviceDO> list = deviceService.list(params);
	   Map<String,Object> map =  new HashMap<String,Object>();
	   map.put("data", list);
	   return map;
	}
	
	/**
	 * 设备添加接口
	 */
	@PostMapping("/add")
	Map<String,Object> add(String identity){
		 Map<String,Object> map = new HashMap<String,Object>();
		 Map<String,Object> params = new HashMap<String,Object>();
		 params.put("identity",identity);
		 List<DeviceDO> list = deviceService.list(params);
		 if(list.size()==0)
			 map.put("msg","设备不存在，添加失败");
		 else{
			 DeviceDO deviceDO = new DeviceDO();
			 deviceDO.setAccount(ShiroUtils.getUser().getPhone());
			 deviceDO.setIdentity(identity);
			 if(deviceService.update(deviceDO)>0)
				 map.put("msg","设备添加成功");
		 }
		 return map;
	}
	
	@PostMapping("/delete")
	Map<String,Object> delete(String identity){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account",ShiroUtils.getUser().getPhone());
		params.put("identity", identity);
		params.put("defaultDevice", 0);
		List<DeviceDO> list = deviceService.list(params);
		if(list.size()>0)
			map.put("msg","默认设备不可删除");
		else{
			DeviceDO deviceDO= new DeviceDO();
			deviceDO.setAccount("");
			deviceDO.setIdentity(identity);
			if(deviceService.update(deviceDO)>0)
				map.put("msg","操作成功");
		}
		return map;
	}
}

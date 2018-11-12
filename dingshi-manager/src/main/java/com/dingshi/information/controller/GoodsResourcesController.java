package com.dingshi.information.controller;

import java.util.ArrayList;
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

import com.dingshi.information.domain.GoodsResourcesDO;
import com.dingshi.information.domain.OrderDO;
import com.dingshi.information.service.GoodsResourcesService;
import com.dingshi.information.service.OrderService;
import com.dingshi.system.service.UserService;
import com.dingshi.common.utils.PageUtils;
import com.dingshi.common.utils.Query;
import com.dingshi.common.utils.R;

/**
 * 货源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-09-27 10:21:16
 */
 
@Controller
@RequestMapping("/information/goodsresources")
public class GoodsResourcesController {
	@Autowired
	private GoodsResourcesService goodsResourcesService;
//	@Autowired
//	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("information:goodsResources:order")
	String Order(){
	    return "information/goodsresources/order";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:goodsResources:order")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsResourcesDO> orderList = goodsResourcesService.list(query);
		int total = goodsResourcesService.count(query);
		PageUtils pageUtils = new PageUtils(orderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:goodsResources:add")
	String add(Model model){
		
	    return "information/goodsresources/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:goodsResources:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GoodsResourcesDO goodsResourcesDO = goodsResourcesService.get(id);
		model.addAttribute("order", goodsResourcesDO);
	    return "information/goodsresources/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:goodsResources:add")
	public R save( GoodsResourcesDO goodsResourcesDO){
		goodsResourcesDO.setOrderType(2);
		if(goodsResourcesService.save(goodsResourcesDO)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:goodsResources:edit")
	public R update( GoodsResourcesDO goodsResourcesDO){
		if(goodsResourcesDO.getDriverPhone()!=null){
			goodsResourcesDO.setOrderType(0);
		}
		goodsResourcesService.update(goodsResourcesDO);
		return R.ok();
	}
	
	/**
	 * 请输入司机手机号
	 */
	
	@GetMapping("/siji/{id}")
	@RequiresPermissions("information:goodsResources:add")
	String addsiji(@PathVariable("id") Integer id, Model model){
		model.addAttribute("id",id);
	    return "information/goodsresources/siji";
	}
	
	/**
	 *保存司机的手机号
	 */
	@ResponseBody
	@RequestMapping("/saveDriver")
	@RequiresPermissions("information:goodsResources:edit")
	public R saveDriver( GoodsResourcesDO goodsResourcesDO){
		goodsResourcesDO.setOrderType(0);
		goodsResourcesService.update(goodsResourcesDO);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:goodsResources:remove")
	public R remove( Integer id){
		GoodsResourcesDO goodsResourcesDO = new GoodsResourcesDO();
		goodsResourcesDO.setId(id);
		goodsResourcesDO.setOrderType(3);
		if(goodsResourcesService.update(goodsResourcesDO)>0){
			return R.ok();
			}
			return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:goodsResources:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		goodsResourcesService.batchRemove(ids);
		return R.ok();
	}
	
}

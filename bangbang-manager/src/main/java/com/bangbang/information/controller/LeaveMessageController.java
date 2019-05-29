package com.bangbang.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.LeaveMessageService;
import com.bangbang.information.service.SubscriberService;


/**
 * 用户留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 18:42:45
 */
 
@Controller
@RequestMapping("/information/leavemessage")
public class LeaveMessageController {
	@Autowired
	private LeaveMessageService messageService;
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping()
	@RequiresPermissions("information:leavemessage:leavemessage")
	String Message(Model model){
		List<SubscriberDO> list = subscriberService.list(new HashMap<String,Object>());
		model.addAttribute("list", list);
	    return "information/leavemessage/message";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:leavemessage:leavemessage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LeaveMessageDO> messageList = messageService.list(query);
		int total = messageService.count(query);
		PageUtils pageUtils = new PageUtils(messageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:leavemessage:add")
	String add(){
	    return "information/leavemessage/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:leavemessage:edit")
	String edit(@PathVariable("id") Long id,Model model){
		LeaveMessageDO message = messageService.get(id);
		model.addAttribute("message", message);
	    return "information/leavemessage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:leavemessage:add")
	public R save( LeaveMessageDO message){
		message.setIfprivate(0);
		message.setIfanswer(1);
		if(messageService.save(message)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:leavemessage:edit")
	public R update( LeaveMessageDO message){
		messageService.update(message);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:leavemessage:remove")
	public R remove( Long id){
		if(messageService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	
	@GetMapping("/detail/{id}")
	@RequiresPermissions("information:leavemessage:detail")
	public String detail(@PathVariable("id") Long id,Model model){
		LeaveMessageDO leaveMessageDO = messageService.get(id);
		model.addAttribute("leaveMessageDO", leaveMessageDO);
		return "information/leavemessage/detail";
	}
	

	@PostMapping( "/updateShowHide")
	@ResponseBody
	@RequiresPermissions("information:leavemessage:leavemessage")
	public R updateShowHide( Long id,Integer enable){
		LeaveMessageDO leaveMessageDO = new LeaveMessageDO();
		leaveMessageDO.setId(id);
		leaveMessageDO.setShowhide(enable);
		if(messageService.update(leaveMessageDO)>0){
		return R.ok();
		}
		return R.error();
	}
}

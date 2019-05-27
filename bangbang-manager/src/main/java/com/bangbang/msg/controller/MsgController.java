package com.bangbang.msg.controller;

import java.util.Date;
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
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseService;
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubcriberLogService;
import com.bangbang.information.service.SubscriberService;
import com.bangbang.msg.domain.MsgDO;
import com.bangbang.msg.domain.MsgUserDO;
import com.bangbang.msg.service.MsgService;
import com.bangbang.msg.service.MsgUserService;



/**
 * 消息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-21 17:28:29
 */
 
@Controller
@RequestMapping("/information/msg")
public class MsgController {
	@Autowired
	private MsgService msgService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SubcriberLogService subcriberLogService;
	@Autowired
	private SubscriberService userService;
	@Autowired
	private MsgUserService msgUserService;
	
	@GetMapping()
	@RequiresPermissions("information:msg:msg")
	String Msg(){
	    return "msg/msg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:msg:msg")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MsgDO> msgList = msgService.list(query);
		int total = msgService.count(query);
		PageUtils pageUtils = new PageUtils(msgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:msg:add")
	String add(Map<String, Object> map,Model model){
		List<CourseDO> courseN = courseService.list(map);
		model.addAttribute("courseN", courseN);
	    return "msg/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:msg:edit")
	String edit(@PathVariable("id") Long id,Model model,Map<String, Object> map){
		List<CourseDO> courseN = courseService.list(map);
		MsgDO msg = msgService.get(id);
		model.addAttribute("courseN", courseN);
		model.addAttribute("msg", msg);
	    return "msg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:msg:add")
	public R save( MsgDO msg){
		msg.setAddTime(new Date());
		msg.setType(0);
		if(msgService.save(msg)>0){
			MsgUserDO msgUser = new MsgUserDO();
			String forNames = msg.getForNames();
			String[] split = forNames.split(",");
			for (String string : split) {
				SubscriberDO subscriberDO = userService.queryId(string);
				msgUser.setUserId(subscriberDO.getId());
				msgUser.setMsgId(msg.getId());
				msgUserService.save(msgUser);
			}
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:msg:edit")
	public R update( MsgDO msg){
		msg.setUpdateTime(new Date());
		msgService.update(msg);
		
		Long id = msg.getId();
		List<MsgUserDO> msgUserId = msgUserService.queryMsgUserId(id);
		for (MsgUserDO msgUserDO : msgUserId) {
			Long mId = msgUserDO.getId();
			msgUserService.remove(mId);
		}
		MsgUserDO msgUser = new MsgUserDO();
		String forNames = msg.getForNames();
		String[] split = forNames.split(",");
		for (String string : split) {
			SubscriberDO subscriberDO = userService.queryId(string);
			msgUser.setUserId(subscriberDO.getId());
			msgUser.setMsgId(msg.getId());
			msgUserService.save(msgUser);
		}
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:msg:remove")
	public R remove( Long id){
		List<MsgUserDO> msgUserId = msgUserService.queryMsgUserId(id);
		for (MsgUserDO msgUserDO : msgUserId) {
			Long mId = msgUserDO.getId();
			msgUserService.remove(mId);
		}
		if(msgService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:msg:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		msgService.batchRemove(ids);
		return R.ok();
	}
	
	@PostMapping("/selectUserName")
	@ResponseBody
	public List<SubcriberLogDO> selectUserName(@RequestParam(value = "courseName", required=false)String courseName){
		List<SubcriberLogDO> userName = subcriberLogService.queryUserName(courseName);
		return userName;
	}
}

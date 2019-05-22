package com.bangbang.information.controller;

import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SendoutCouponDO;
import com.bangbang.information.domain.SendoutReedeemDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.ReedeemService;
import com.bangbang.information.service.SendoutReedeemService;
import com.bangbang.information.service.SubscriberService;


/**
 * 兑换码发放表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 15:32:01
 */
 
@Controller
@RequestMapping("/information/sendoutreedeem")
public class SendoutReedeemController {
	@Autowired
	private SendoutReedeemService sendoutReedeemService;
	@Autowired
	private ReedeemService reedemService;
	@Autowired
	private SubscriberService subcriberService;
	
	@GetMapping("/{id}")
	@RequiresPermissions("information:reedeem:reedeem")
	String Reedeem(@PathVariable("id") Integer id,Model model){
		model.addAttribute("userId",id);
	    return "information/sendoutreedeem/reedeem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:reedeem:reedeem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SendoutReedeemDO> reedeemList = sendoutReedeemService.list(query);
		for(SendoutReedeemDO s :reedeemList){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(s.getSendoutTime());
			calendar.add(Calendar.DAY_OF_YEAR,s.getValidity());
			if(calendar.getTime().compareTo(new Date())<0){
				s.setUsecoupon("<font color='red'>已过期</font>");
			}
			else
				s.setUsecoupon("<font color='green'>未过期</font>");
		}
		int total = sendoutReedeemService.count(query);
		PageUtils pageUtils = new PageUtils(reedeemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{reedeemCode}/{reedeemId}/{reedeemType}/{reedeemSurplus}/{reedeemBalance}/{courseName}/{validity}")
	@RequiresPermissions("information:reedeem:add")
	String add(@PathVariable("reedeemCode") String reedeemCode,@PathVariable("reedeemId") Long reedeemId,
			@PathVariable("reedeemType") Integer reedeemType,@PathVariable("reedeemSurplus") Integer reedeemSurplus ,
			@PathVariable("reedeemBalance") Integer reedeemBalance,@PathVariable("courseName") String courseName, 
			@PathVariable("validity") Integer validity, Model model){
		List<SubscriberDO> list = subcriberService.list(new HashMap<String,Object>());
		model.addAttribute("reedeemCode",reedeemCode);
		model.addAttribute("reedeemId",reedeemId);
		model.addAttribute("reedeemType",reedeemType);
		model.addAttribute("reedeemSurplus",reedeemSurplus);
		model.addAttribute("list",list);
		model.addAttribute("reedeemBalance",reedeemBalance);
		model.addAttribute("courseName",courseName);
		model.addAttribute("validity",validity);
	    return "information/sendoutreedeem/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:reedeem:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SendoutReedeemDO reedeem = sendoutReedeemService.get(id);
		model.addAttribute("reedeem", reedeem);
	    return "information/sendoutreedeem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:reedeem:add")
	public R save( SendoutReedeemDO reedeem){
		int length=0;
		if((length=reedeem.getUserIdArray().length)>0){
			for(int i=0;i<length;i++){
				reedeem.setUserId(reedeem.getUserIdArray()[i]);
				reedeem.setSendoutTime(new Date());
				reedeem.setIfUsed(0);
				reedeem.setDeleteFlag(0);
				sendoutReedeemService.save(reedeem);
			}
			
			reedemService.updateByReemId(reedeem.getReedeemId(),length);
		}
		return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:reedeem:edit")
	public R update( SendoutReedeemDO reedeem){
		sendoutReedeemService.update(reedeem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:reedeem:remove")
	public R remove( Long id){
		if(sendoutReedeemService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:reedeem:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		sendoutReedeemService.batchRemove(ids);
		return R.ok();
	}
	
}

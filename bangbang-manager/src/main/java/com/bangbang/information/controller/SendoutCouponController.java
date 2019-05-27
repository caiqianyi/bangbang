package com.bangbang.information.controller;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseService;
import com.bangbang.information.domain.SendoutCouponDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.CouponService;
import com.bangbang.information.service.SendoutCouponService;
import com.bangbang.information.service.SubscriberService;



/**
 * 优惠券发放表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 13:53:53
 */
 
@Controller
@RequestMapping("/information/sendoutcoupon")
public class SendoutCouponController {
	@Autowired
	private SendoutCouponService sendoutcouponService;
	@Autowired
	private SubscriberService subcriberService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/{id}")
	@RequiresPermissions("information:coupon:sendout")
	String Coupon(@PathVariable("id") Integer id,Model model){
		model.addAttribute("userId",id);
	    return "information/sendoutcoupon/sendoutcoupon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:coupon:sendout")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SendoutCouponDO> couponList = sendoutcouponService.list(query);
		for(SendoutCouponDO s :couponList){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(s.getSendoutTime());
			calendar.add(Calendar.DAY_OF_YEAR,s.getValidity());
			if(calendar.getTime().compareTo(new Date())<0){
				s.setUsecoupon("<font color='red'>已过期</font>");
			}
			else
				s.setUsecoupon("<font color='green'>未过期</font>");
		}
		int total = sendoutcouponService.count(query);
		PageUtils pageUtils = new PageUtils(couponList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{couponId}/{couponSurplus}/{couponBalance}/{validity}")
	@RequiresPermissions("information:coupon:sendout")
	String add(@PathVariable("couponId") Long couponId,@PathVariable("couponSurplus")Long couponSurplus,
			@PathVariable("couponBalance")Long couponBalance,@PathVariable("validity") Integer validity,  Model model){
		List<SubscriberDO> list = subcriberService.list(new HashMap<String,Object>());
		List<CourseDO> courseDOs=courseService.list(new HashMap<String,Object>());
		model.addAttribute("courseDOs",courseDOs);
		model.addAttribute("couponId", couponId);
		model.addAttribute("list", list);
		model.addAttribute("validity",validity);
		model.addAttribute("couponSurplus",couponSurplus);
	    return "information/sendoutcoupon/sendoutadd";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:coupon:sendout")
	String edit(@PathVariable("id") Long id,Model model){
		SendoutCouponDO coupon = sendoutcouponService.get(id);
		model.addAttribute("coupon", coupon);
	    return "information/sendoutcoupon/sendoutedit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:coupon:sendout")
	public R save( Long couponId,Integer validity,Integer couponGroup,Long[] userIdArray){
		for(int i=0;i<userIdArray.length;i++){
			SendoutCouponDO coupon = new SendoutCouponDO();
			coupon.setUserId(userIdArray[i]);
			coupon.setSendoutTime(new Date());
			coupon.setCouponId(couponId);
			coupon.setValidity(validity);
			coupon.setCouponGroup(couponGroup);
			coupon.setIfUser(1);
			sendoutcouponService.save(coupon);
		}
		couponService.updateBycouponId(couponId,userIdArray.length);
		
		return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:coupon:sendout")
	public R update( SendoutCouponDO coupon){
		sendoutcouponService.update(coupon);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:coupon:sendout")
	public R remove( Long id){
		if(sendoutcouponService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:coupon:sendout")
	public R remove(@RequestParam("ids[]") Long[] ids){
		sendoutcouponService.batchRemove(ids);
		return R.ok();
	}
}

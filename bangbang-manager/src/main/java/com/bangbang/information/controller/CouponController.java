package com.bangbang.information.controller;

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
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.service.CouponService;


/**
 * 优惠券表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 09:40:06
 */
 
@Controller
@RequestMapping("/information/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private CourseService couseService;
	
	@GetMapping()
	@RequiresPermissions("information:coupon:coupon")
	String Coupon(){
	    return "information/coupon/coupon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:coupon:coupon")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CouponDO> couponList = couponService.list(query);
		
		int total = couponService.count(query);
		PageUtils pageUtils = new PageUtils(couponList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:coupon:add")
	String add(Model model){
		List<CourseDO> courseDOs=couseService.list(new HashMap<String,Object>());
		model.addAttribute("courseDOs", courseDOs);
	    return "information/coupon/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:coupon:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CouponDO coupon = couponService.get(id);
		model.addAttribute("coupon", coupon);
		List<CourseDO> courseDOs=couseService.list(new HashMap<String,Object>());
		model.addAttribute("courseDOs", courseDOs);
	    return "information/coupon/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:coupon:add")
	public R save( CouponDO coupon){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("couponId", coupon.getCouponId());
		if(!couponService.list(map).isEmpty())
			return R.error("优惠券编号已存在");
		coupon.setCreateTime(new Date());
		coupon.setCouponSurplus(coupon.getCouponCount());
		coupon.setDeleteFlag(0);
		if(couponService.save(coupon)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:coupon:edit")
	public R update( CouponDO coupon){
		coupon.setCouponSurplus(coupon.getCouponCount());
		couponService.update(coupon);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:coupon:remove")
	public R remove( Long id){
		if(couponService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:coupon:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		couponService.batchRemove(ids);
		return R.ok();
	}
	
}

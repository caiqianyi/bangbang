package com.bangbang.information.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangbang.common.annotation.Log;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.CouponService;


@RestController
@RequestMapping("/bangbang/coupon")
public class CouponController {
	
	@Autowired
	private CouponService couponService;


	/**
	 * 查询用户的优惠券
	 */
	@Log("查询用户的优惠券接口")
	@GetMapping("/listCoupon")
	public Map<String,Object> listCoupon(long id){
		Map<String,Object> map  =new HashMap<String,Object>();
		List<CouponDO> list = couponService.listCoupon(id);
		if(list.size()==0){
			map.put("code", 1);
			map.put("msg","您当前没有优惠券");
		}
		else{
			for(CouponDO s :list){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(s.getSendoutTime());
				calendar.add(Calendar.DAY_OF_YEAR,s.getValidity());
				s.setValidityTime(calendar.getTime());
				if(calendar.getTime().compareTo(new Date())<0 && s.getIfUser()==1){
					s.setIfUser(2);//已过期
				}
			}
			map.put("code", 0);
			map.put("data", list);
			map.put("msg","");
		}
		
		return map;
	}
	
	/**
	 * 兑换码兑换优惠券
	 */
	
	@Log("兑换码兑换优惠券接口")
	@PostMapping("/reedeemDuihuan")
	public Map<String,Object> reedeemDuihuan(Long id,String reedeemCode){
		Map<String,Object> map = new HashMap<String,Object>();
		List<ReedeemDO> reedeemDOs= couponService.getReedeem(id,reedeemCode);
		if(reedeemDOs.size()>0){
			ReedeemDO reedeemDO=reedeemDOs.get(0);
			if(reedeemDO.getIfUsed()==0){
				map.put("code", 1);
				map.put("msg","兑换码已经使用");
			}
			else{
					int reedeemType=reedeemDO.getReedeemType();
					if(reedeemType==0||reedeemType==1){
						map.put("code",1);
						map.put("msg","只能兑换课程或余额");
					}
					else{//兑换码兑换优惠券
						couponService.updateReedeemIfUsed(id,reedeemCode);//已使用
						CouponDO couponDO=couponService.getCouponByCouponId(reedeemDO.getCouponId());
						if(couponDO!=null){
							couponDO.setUserId(id);
							couponDO.setIfUser(1);
							couponDO.setSendoutTime(new Date());
							couponDO.setCouponGroup(3);
							int result = couponService.saveSendoutCoupon(couponDO);
							if(result>0){
								map.put("code",0);
								map.put("msg","兑换优惠券成功");
							}	
						}
					}
					
				
			}
		}
		else{
			map.put("code", 1);
			map.put("msg","兑换码不存在");
		}
		
		return map;
	}
}

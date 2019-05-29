package com.bangbang.information.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangbang.common.annotation.Log;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
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
		List<CouponDO> list = couponService.listCoupon(id);
		for(CouponDO s :list){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(s.getSendoutTime());
			calendar.add(Calendar.DAY_OF_YEAR,s.getValidity());
			s.setValidityTime(calendar.getTime());
			if(calendar.getTime().compareTo(new Date())<0 && s.getIfUser()==1){
				s.setIfUser(2);//已过期
			}
		
		}
		Map<String,Object> map  =new HashMap<String,Object>();
		map.put("data", list);
		return map;
	}
	
	/**
	 * 兑换码兑换优惠券
	 */
	
	@Log("兑换码兑换优惠券接口")
	@GetMapping("/reedeemDuihuan")
	public Map<String,Object> reedeemDuihuan(Long id,String reedeemCode){
		Map<String,Object> map = new HashMap<String,Object>();
		ReedeemDO reedeemDO= couponService.getReedeem(id,reedeemCode);
		if(reedeemCode!=null){
			if(reedeemDO.getIfUsed()==0){
				map.put("errcode", 1);
				map.put("msg","兑换码已经使用");
			}
			else{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(reedeemDO.getSendoutTime());
				calendar.add(Calendar.DAY_OF_YEAR,reedeemDO.getValidity());
				if(calendar.getTime().compareTo(new Date())<0){
					map.put("errcode",1);
					map.put("msg","兑换码已过期");
				}
				else{
					int reedeemType=0;
					if((reedeemType=reedeemDO.getReedeemType())==0||reedeemType==1){
						map.put("errcode",1);
						map.put("msg","只能兑换课程或余额");
					}
					else{//兑换码兑换优惠券
						couponService.updateReedeemIfUsed(id,reedeemCode);//已使用
					}
				}
			}
		}
		else{
			map.put("errcode", 1);
			map.put("msg","兑换码不存在");
		}
		
		return map;
	}
}

package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bangbang.information.dao.SendoutCouponDao;
import com.bangbang.information.domain.SendoutCouponDO;
import com.bangbang.information.service.SendoutCouponService;


@Service
public class SendoutCouponServiceImpl implements SendoutCouponService {
	@Autowired
	private SendoutCouponDao couponDao;
	
	@Override
	public SendoutCouponDO get(Long id){
		return couponDao.get(id);
	}
	
	@Override
	public List<SendoutCouponDO> list(Map<String, Object> map){
		return couponDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return couponDao.count(map);
	}
	
	@Override
	public int save(SendoutCouponDO coupon){
		return couponDao.save(coupon);
	}
	
	@Override
	public int update(SendoutCouponDO coupon){
		return couponDao.update(coupon);
	}
	
	@Override
	public int remove(Long id){
		return couponDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return couponDao.batchRemove(ids);
	}
	
}

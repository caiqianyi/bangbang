package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.CouponDao;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.service.CouponService;

import java.util.List;
import java.util.Map;





@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public CouponDO get(Long id){
		return couponDao.get(id);
	}
	
	@Override
	public List<CouponDO> list(Map<String, Object> map){
		return couponDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return couponDao.count(map);
	}
	
	@Override
	public int save(CouponDO coupon){
		return couponDao.save(coupon);
	}
	
	@Override
	public int update(CouponDO coupon){
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

	@Override
	public void updateBycouponId(Long couponId,Integer length) {
		couponDao.updateBycouponId(couponId,length);
	}
	
}

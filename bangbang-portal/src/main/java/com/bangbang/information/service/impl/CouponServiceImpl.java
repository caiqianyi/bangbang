package com.bangbang.information.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangbang.information.dao.CouponDao;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.service.CouponService;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponDao couponDao; 
	@Override
	public List<CouponDO> listCoupon(long id) {
		return couponDao.listCoupon(id);
	}
	@Override
	public ReedeemDO getReedeem(Long id,String reedeemCode) {
		return couponDao.getReedeem(id,reedeemCode);
	}
	@Override
	public int updateReedeemIfUsed(Long id, String reedeemCode) {
		 return couponDao.updateReedeemIfUsed(id,reedeemCode);
	}
	@Override
	public CouponDO getCouponByCouponId(Long couponId) {
	
		return  couponDao.getCouponByCouponId(couponId);
	}
	@Override
	public int saveSendoutCoupon(CouponDO couponDO) {
		
		return couponDao.saveSendoutCoupon(couponDO);
	}

}

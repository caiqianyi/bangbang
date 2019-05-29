package com.bangbang.information.service;

import java.util.List;

import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;

public interface CouponService {

	List<CouponDO> listCoupon(long id);

	ReedeemDO getReedeem(Long id,String reedeemCode);

	void updateReedeemIfUsed(Long id, String reedeemCode);

}

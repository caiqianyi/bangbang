package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.CouponDO;

/**
 * 优惠券表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 09:40:06
 */
public interface CouponService {
	
	CouponDO get(Long id);
	
	List<CouponDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CouponDO coupon);
	
	int update(CouponDO coupon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	void updateBycouponId(Long couponId,Integer length);
}

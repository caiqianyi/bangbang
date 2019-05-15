package com.bangbang.information.service;

import com.bangbang.information.domain.SendoutCouponDO;

import java.util.List;
import java.util.Map;

/**
 * 优惠券发放表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 13:53:53
 */
public interface SendoutCouponService {
	
	SendoutCouponDO get(Long id);
	
	List<SendoutCouponDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SendoutCouponDO coupon);
	
	int update(SendoutCouponDO coupon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

package com.bangbang.information.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.information.domain.SendoutCouponDO;

/**
 * 优惠券发放表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-13 13:53:53
 */
@Mapper
public interface SendoutCouponDao {

	SendoutCouponDO get(Long id);
	
	List<SendoutCouponDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SendoutCouponDO coupon);
	
	int update(SendoutCouponDO coupon);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

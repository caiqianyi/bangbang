package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.common.utils.Query;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SendoutReedeemDO;

/**
 * 兑换码表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 13:35:00
 */
public interface ReedeemService {
	
	ReedeemDO get(Long id);
	
	List<ReedeemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ReedeemDO reedeem);
	
	int update(ReedeemDO reedeem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	void updateByReemId(Long id, int length);

	int savelist(List<ReedeemDO> list);
	
	List<CouponDO> getCoupon();


	List<ReedeemDO> duihuanyonghulist(Map<String, Object> params);

	List<SendoutReedeemDO> userreedeemlist(Map<String,Object> map);

	List<Map<String, Object>> exeList(Map<String, Object> map);

}

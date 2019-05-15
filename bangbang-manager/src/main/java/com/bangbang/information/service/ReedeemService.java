package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.ReedeemDO;

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
}

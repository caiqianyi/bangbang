package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.SubscriberDO;

/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 10:03:50
 */
public interface SubscriberService {
	
	SubscriberDO get(Long id);
	
	List<SubscriberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubscriberDO user);
	
	int update(SubscriberDO user);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

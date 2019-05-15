package com.bangbang.information.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.information.domain.SubscriberDO;

/**
 * 用户信息表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 10:03:50
 */
@Mapper
public interface SubscriberDao {

	SubscriberDO get(Long id);
	
	List<SubscriberDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SubscriberDO user);
	
	int update(SubscriberDO user);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
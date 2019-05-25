package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.SubscriberDao;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubscriberService;

import java.util.List;
import java.util.Map;



@Service
public class SubscriberServiceImpl implements SubscriberService {
	@Autowired
	private SubscriberDao userDao;
	
	@Override
	public SubscriberDO get(Long id){
		return userDao.get(id);
	}
	
	@Override
	public List<SubscriberDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(SubscriberDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(SubscriberDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Long id){
		return userDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userDao.batchRemove(ids);
	}

	@Override
	public List<Map<String, Object>> exeList(Map<String, Object> map) {
		return userDao.exeList(map);
	}
	
}

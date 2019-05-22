package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.LeaveMessageDao;
import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.service.LeaveMessageService;

import java.util.List;
import java.util.Map;




@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {
	@Autowired
	private LeaveMessageDao messageDao;
	
	@Override
	public LeaveMessageDO get(Long id){
		return messageDao.get(id);
	}
	
	@Override
	public List<LeaveMessageDO> list(Map<String, Object> map){
		return messageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return messageDao.count(map);
	}
	
	@Override
	public int save(LeaveMessageDO message){
		return messageDao.save(message);
	}
	
	@Override
	public int update(LeaveMessageDO message){
		return messageDao.update(message);
	}
	
	@Override
	public int remove(Long id){
		return messageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return messageDao.batchRemove(ids);
	}
	
}

package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.SendoutReedeemDao;
import com.bangbang.information.domain.SendoutReedeemDO;
import com.bangbang.information.service.SendoutReedeemService;

import java.util.List;
import java.util.Map;





@Service
public class SendoutReedeemServiceImpl implements SendoutReedeemService {
	@Autowired
	private SendoutReedeemDao reedeemDao;
	
	@Override
	public SendoutReedeemDO get(Long id){
		return reedeemDao.get(id);
	}
	
	@Override
	public List<SendoutReedeemDO> list(Map<String, Object> map){
		return reedeemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reedeemDao.count(map);
	}
	
	@Override
	public int save(SendoutReedeemDO reedeem){
		return reedeemDao.save(reedeem);
	}
	
	@Override
	public int update(SendoutReedeemDO reedeem){
		return reedeemDao.update(reedeem);
	}
	
	@Override
	public int remove(Long id){
		return reedeemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return reedeemDao.batchRemove(ids);
	}
	
}

package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bangbang.information.dao.RechargeRecordDao;
import com.bangbang.information.domain.RechargeRecordDO;
import com.bangbang.information.service.RechargeRecordService;



@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {
	@Autowired
	private RechargeRecordDao rechargeRecordDao;
	
	@Override
	public RechargeRecordDO get(Integer id){
		return rechargeRecordDao.get(id);
	}
	
	@Override
	public List<RechargeRecordDO> list(Map<String, Object> map){
		return rechargeRecordDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return rechargeRecordDao.count(map);
	}
	
	@Override
	public int save(RechargeRecordDO rechargeRecord){
		return rechargeRecordDao.save(rechargeRecord);
	}
	
	@Override
	public int update(RechargeRecordDO rechargeRecord){
		return rechargeRecordDao.update(rechargeRecord);
	}
	
	@Override
	public int remove(Integer id){
		return rechargeRecordDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return rechargeRecordDao.batchRemove(ids);
	}
	
}

package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.PlayRecordDao;
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.service.PlayRecordService;

import java.util.List;
import java.util.Map;



@Service
public class PlayRecordServiceImpl implements PlayRecordService {
	@Autowired
	private PlayRecordDao recordDao;
	
	@Override
	public PlayRecordDO get(Integer id){
		return recordDao.get(id);
	}
	
	@Override
	public List<PlayRecordDO> list(Map<String, Object> map){
		return recordDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return recordDao.count(map);
	}
	
	@Override
	public int save(PlayRecordDO record){
		return recordDao.save(record);
	}
	
	@Override
	public int update(PlayRecordDO record){
		return recordDao.update(record);
	}
	
	@Override
	public int remove(Integer id){
		return recordDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return recordDao.batchRemove(ids);
	}
	
}

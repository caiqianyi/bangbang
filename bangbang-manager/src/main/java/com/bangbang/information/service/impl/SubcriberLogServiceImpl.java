package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.SubcriberLogDao;
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.service.SubcriberLogService;

import java.util.List;
import java.util.Map;




@Service
public class SubcriberLogServiceImpl implements SubcriberLogService {
	@Autowired
	private SubcriberLogDao logDao;
	
	@Override
	public SubcriberLogDO get(Integer id){
		return logDao.get(id);
	}
	
	@Override
	public List<SubcriberLogDO> list(Map<String, Object> map){
		return logDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return logDao.count(map);
	}
	
	@Override
	public int save(SubcriberLogDO log){
		return logDao.save(log);
	}
	
	@Override
	public int update(SubcriberLogDO log){
		return logDao.update(log);
	}
	
	@Override
	public int remove(Integer id){
		return logDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return logDao.batchRemove(ids);
	}
	
}

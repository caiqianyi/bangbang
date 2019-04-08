package com.zhenjiu.information.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenjiu.information.dao.DataDao;
import com.zhenjiu.information.domain.DataDO;
import com.zhenjiu.information.domain.DataVO;
import com.zhenjiu.information.service.DataService;




@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private DataDao dataDao;
	
	@Override
	public DataDO get(Integer id){
		return dataDao.get(id);
	}
	
	@Override
	public List<DataDO> list(Map<String, Object> map){
		return dataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dataDao.count(map);
	}
	
	@Override
	public int save(DataDO data){
		return dataDao.save(data);
	}
	
	@Override
	public int update(DataDO data){
		return dataDao.update(data);
	}
	
	@Override
	public int remove(Integer id){
		return dataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return dataDao.batchRemove(ids);
	}

	@Override
	public List<DataDO> selectByMonth(Map<String, Object> params) {
		
		return dataDao.selectByMonth(params);
	}

	@Override
	public List<DataDO> selectByWeek(Map<String, Object> params) {
		return  dataDao.selectByWeek(params);
	}

	@Override
	public List<DataDO> selectByDay(Map<String, Object> params) {
		return  dataDao.selectByDay(params);
	}


	@Override
	public List<DataDO> selectUsername(Map<String, Object> params) {
		return null;
	}
/*
	@Override
	public List<DataDO> selectBytime(DataVO datavo) {
		return dataDao.selectBytime(datavo);
	}*/
	
}

package com.zhenjiu.information.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenjiu.information.dao.DataStatisticsDao;
import com.zhenjiu.information.domain.DataDO;
import com.zhenjiu.information.service.DataStatisticsService;
@Service
public class DataStatisticsServiceImpl implements DataStatisticsService {
	
	@Autowired
	private DataStatisticsDao dataStatisticsDao;
	
	@Override
	public DataDO get(Integer id){
		return dataStatisticsDao.get(id);
	}
	
	@Override
	public List<DataDO> list(Map<String, Object> map){
		return dataStatisticsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dataStatisticsDao.count(map);
	}
	
	@Override
	public int save(DataDO data){
		return dataStatisticsDao.save(data);
	}
	
	@Override
	public int update(DataDO data){
		return dataStatisticsDao.update(data);
	}
	
	@Override
	public int remove(Integer id){
		return dataStatisticsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return dataStatisticsDao.batchRemove(ids);
	}

	@Override
	public List<DataDO> selectByUsername(String name) {
		return dataStatisticsDao.selectByUsername(name);
	}

	@Override
	public List<Map<String, Object>> exeList(Map<String, Object> map) {
		
		return dataStatisticsDao.exeList(map);
	}
	
}



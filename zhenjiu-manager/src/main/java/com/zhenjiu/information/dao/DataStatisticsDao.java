package com.zhenjiu.information.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.zhenjiu.information.domain.DataDO;


public interface DataStatisticsDao {
	
	DataDO get(Integer id);
	
	List<DataDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DataDO data);
	
	int update(DataDO data);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	
	List<DataDO> selectByMonth(Map<String,Object> map);
	
	List<DataDO> selectByWeek(Map<String,Object> map);

	List<DataDO> selectByday(Map<String, Object> map);
	
	
	List<DataDO> selectUsername(Map<String,Object> map);
	
	List<DataDO> selectByUsername(String name);

	
}

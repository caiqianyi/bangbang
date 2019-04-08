package com.zhenjiu.information.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhenjiu.common.utils.Query;
import com.zhenjiu.information.domain.DataDO;

@Mapper
public interface DataStatisticsService {

	DataDO get(Integer id);
	
	List<DataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DataDO data);
	
	int update(DataDO data);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	List<DataDO> selectByMonth(Map<String,Object> map);
	
	List<DataDO> selectByWeek(Map<String,Object> map);
	
	List<DataDO> selectByday(Map<String,Object> map);
	
	List<DataDO> selectByUsername(String name);

	

	


}

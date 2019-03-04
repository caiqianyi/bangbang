package com.zhenjiu.data.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhenjiu.data.domain.DataDO;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-03-01 14:48:35
 */
@Mapper
public interface DataDao {

	DataDO get(Integer id);
	
	List<DataDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DataDO data);
	
	int update(DataDO data);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<DataDO> getTreeDataByDate(@Param("userid") Long userid, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
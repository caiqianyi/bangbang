package com.zhenjiu.data.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zhenjiu.data.domain.DataDO;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-03-01 14:48:35
 */
public interface DataService {
	
	DataDO get(Integer id);
	
	List<DataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DataDO data);
	
	int update(DataDO data);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<DataDO> getTreeDataByDate(int i, Date startDate, Date endDate);
}

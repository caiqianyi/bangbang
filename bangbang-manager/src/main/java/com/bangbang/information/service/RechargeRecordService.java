package com.bangbang.information.service;

import com.bangbang.information.domain.RechargeRecordDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 17:38:48
 */
public interface RechargeRecordService {
	
	RechargeRecordDO get(Integer id);
	
	List<RechargeRecordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RechargeRecordDO rechargeRecord);
	
	int update(RechargeRecordDO rechargeRecord);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

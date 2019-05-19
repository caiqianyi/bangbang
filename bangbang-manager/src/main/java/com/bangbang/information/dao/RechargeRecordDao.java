package com.bangbang.information.dao;

import com.bangbang.information.domain.RechargeRecordDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 17:38:48
 */
@Mapper
public interface RechargeRecordDao {

	RechargeRecordDO get(Integer id);
	
	List<RechargeRecordDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RechargeRecordDO rechargeRecord);
	
	int update(RechargeRecordDO rechargeRecord);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

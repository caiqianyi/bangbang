package com.dingshi.owneruser.dao;

import com.dingshi.owneruser.domain.OwnerUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author tmn
 */
@Mapper
public interface OwnerUserDao {

	OwnerUserDO get(Long userId);
	
	OwnerUserDO getup(OwnerUserDO user);
	
	List<OwnerUserDO> list(Map<String,Object> map);
	List<Map<String, Object>> exeList(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int update(OwnerUserDO user);
	
	int remove(Long userId);
	

}

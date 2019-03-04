package com.zhenjiu.owneruser.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhenjiu.owneruser.domain.OwnerUserDO;

/**
 * 
 * @author tmn
 */
@Mapper
public interface OwnerUserDao {

	OwnerUserDO get(Long userId);
	
	OwnerUserDO getbyname(String phone);
	
	List<OwnerUserDO> list(Map<String,Object> map);
	
	int save(OwnerUserDO user);
	
	int count(Map<String,Object> map);
	
	int update(OwnerUserDO user);
	
	int remove(Long userId);
	

}

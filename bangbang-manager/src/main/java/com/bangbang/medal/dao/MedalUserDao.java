package com.bangbang.medal.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.medal.domain.MedalUserDO;

/**
 * 用户勋章中间表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-30 16:46:50
 */
@Mapper
public interface MedalUserDao {

	MedalUserDO get(Integer id);
	
	List<MedalUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MedalUserDO medalUser);
	
	int update(MedalUserDO medalUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
}

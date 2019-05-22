package com.bangbang.medal.service;


import java.util.List;
import java.util.Map;

import com.bangbang.medal.domain.MedalDO;

/**
 * 勋章表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 10:26:16
 */
public interface MedalService {
	
	MedalDO get(Long id);
	
	List<MedalDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MedalDO medal);
	
	int update(MedalDO medal);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	boolean boolId(Map<String,Object> params);

}

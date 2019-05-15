package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.SubcriberLogDO;

/**
 * 购买转发收藏表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 14:01:30
 */
public interface SubcriberLogService {
	
	SubcriberLogDO get(Integer id);
	
	List<SubcriberLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubcriberLogDO log);
	
	int update(SubcriberLogDO log);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

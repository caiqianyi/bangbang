package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.VersionManagementDO;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-04-16 09:53:33
 */
public interface VersionManagementService {
	
	VersionManagementDO get(Integer id);
	
	List<VersionManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(VersionManagementDO versionManagement);
	
	int update(VersionManagementDO versionManagement);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

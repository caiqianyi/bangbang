package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.HelpDO;

/**
 * 帮助表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 15:45:34
 */
public interface HelpService {
	
	HelpDO get(Integer id);
	
	List<HelpDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HelpDO help);
	
	int update(HelpDO help);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

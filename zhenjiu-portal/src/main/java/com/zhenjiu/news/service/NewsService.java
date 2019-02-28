package com.zhenjiu.news.service;


import java.util.List;
import java.util.Map;

import com.zhenjiu.news.domain.NewsDO;

/**
 * 咨讯表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-15 16:39:38
 */
public interface NewsService {
	
	NewsDO get(Long id);
	
	List<NewsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NewsDO news);
	
	int update(NewsDO news);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

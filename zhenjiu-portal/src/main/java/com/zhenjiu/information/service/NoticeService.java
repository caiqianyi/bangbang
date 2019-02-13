package com.zhenjiu.information.service;

import java.util.List;
import java.util.Map;

import com.zhenjiu.information.domain.NoticeDO;

/**
 * 公告表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-04-13 13:10:58
 */
public interface NoticeService {
	
	NoticeDO get(Integer id);
	
	List<NoticeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NoticeDO notice);
	
	int update(NoticeDO notice);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
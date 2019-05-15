package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.PlayRecordDO;

/**
 * 播放记录表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 15:51:59
 */
public interface PlayRecordService {
	
	PlayRecordDO get(Integer id);
	
	List<PlayRecordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PlayRecordDO record);
	
	int update(PlayRecordDO record);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

package com.bangbang.msg.service;


import java.util.List;
import java.util.Map;

import com.bangbang.msg.domain.MsgDO;

/**
 * 消息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-21 17:28:29
 */
public interface MsgService {
	
	MsgDO get(Long id);
	
	List<MsgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MsgDO msg);
	
	int update(MsgDO msg);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

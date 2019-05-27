package com.bangbang.msg.service;


import java.util.List;
import java.util.Map;

import com.bangbang.msg.domain.MsgUserDO;

/**
 * 消息用户中间表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-27 10:42:09
 */
public interface MsgUserService {
	
	MsgUserDO get(Long id);
	
	List<MsgUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MsgUserDO msgUser);
	
	int update(MsgUserDO msgUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<MsgUserDO> queryMsgUserId(Long msgId);

}

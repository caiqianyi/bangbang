package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.LeaveMessageDO;

/**
 * 用户留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 18:42:45
 */
public interface LeaveMessageService {
	
	LeaveMessageDO get(Long id);
	
	List<LeaveMessageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LeaveMessageDO message);
	
	int update(LeaveMessageDO message);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

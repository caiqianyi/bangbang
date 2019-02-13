package com.zhenjiu.users.service;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zhenjiu.common.domain.Tree;
import com.zhenjiu.system.domain.DeptDO;
import com.zhenjiu.users.domain.UserDO;

/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-09-27 10:18:38
 */

public interface UserService {
	
	UserDO get(Integer id);
	
	UserDO getidbyphone(String phone);
	
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

}
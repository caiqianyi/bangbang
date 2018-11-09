package com.dingshi.users.service.impl;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingshi.common.domain.Tree;
import com.dingshi.common.utils.BuildTree;
import com.dingshi.system.domain.DeptDO;
import com.dingshi.users.dao.UserDao;
import com.dingshi.users.domain.UserDO;
import com.dingshi.users.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDO get(Integer id){
		return userDao.get(id);
	}
	
	@Override
	public List<UserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(UserDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(UserDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Integer id){
		return userDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userDao.batchRemove(ids);
	}



	
}

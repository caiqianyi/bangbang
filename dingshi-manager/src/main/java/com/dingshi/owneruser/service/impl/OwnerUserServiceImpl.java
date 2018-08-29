package com.dingshi.owneruser.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dingshi.common.config.BootdoConfig;
import com.dingshi.common.service.FileService;
import com.dingshi.owneruser.dao.OwnerUserDao;
import com.dingshi.owneruser.domain.OwnerUserDO;
import com.dingshi.owneruser.service.OwnerUserService;
import com.dingshi.system.dao.DeptDao;
import com.dingshi.system.dao.UserRoleDao;
import com.dingshi.system.service.UserService;

@Transactional
@Service
public class OwnerUserServiceImpl implements OwnerUserService {
	@Autowired
	OwnerUserDao ownerUserMapper;
	@Autowired
	UserRoleDao userRoleMapper;
	@Autowired
	DeptDao deptMapper;
	@Autowired
	private FileService sysFileService;
	@Autowired
	private BootdoConfig bootdoConfig;
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Override
	public OwnerUserDO get(Long id) {
		OwnerUserDO user = ownerUserMapper.get(id);
		return user;
	}
	
	@Override
	public OwnerUserDO getup(OwnerUserDO user1) {
		OwnerUserDO user = ownerUserMapper.getup(user1);
		return user;
	}
	
	@Override
	public List<OwnerUserDO> list(Map<String, Object> map) {
		return ownerUserMapper.list(map);
	}
	@Override
	public List<Map<String, Object>> exeList(Map<String, Object> map) {
		return ownerUserMapper.exeList(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return ownerUserMapper.count(map);
	}


	@Override
	public int update(OwnerUserDO user) {
		int r = ownerUserMapper.update(user);
		
		return r;
	}

	@Override
	public int remove(Long userId) {
		userRoleMapper.removeByUserId(userId);
		return ownerUserMapper.remove(userId);
	}

	@Override
	public boolean exit(Map<String, Object> params) {
		boolean exit;
		exit = ownerUserMapper.list(params).size() > 0;
		return exit;
	}



}

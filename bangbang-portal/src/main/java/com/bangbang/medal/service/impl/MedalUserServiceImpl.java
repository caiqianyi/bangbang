package com.bangbang.medal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.medal.dao.MedalUserDao;
import com.bangbang.medal.domain.MedalUserDO;
import com.bangbang.medal.service.MedalUserService;

import java.util.List;
import java.util.Map;




@Service
public class MedalUserServiceImpl implements MedalUserService {
	@Autowired
	private MedalUserDao medalUserDao;
	
	@Override
	public MedalUserDO get(Integer id){
		return medalUserDao.get(id);
	}
	
	@Override
	public List<MedalUserDO> list(Map<String, Object> map){
		return medalUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return medalUserDao.count(map);
	}
	
	@Override
	public int save(MedalUserDO medalUser){
		return medalUserDao.save(medalUser);
	}
	
	@Override
	public int update(MedalUserDO medalUser){
		return medalUserDao.update(medalUser);
	}
	
	@Override
	public int remove(Integer id){
		return medalUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return medalUserDao.batchRemove(ids);
	}

	@Override
	public List<MedalUserDO> medalUserList(Long userId) {
		return medalUserDao.medalUserList(userId);
	}
	
}

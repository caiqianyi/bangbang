package com.bangbang.medal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.medal.dao.MedalDao;
import com.bangbang.medal.domain.MedalDO;
import com.bangbang.medal.service.MedalService;

import java.util.List;
import java.util.Map;





@Service
public class MedalServiceImpl implements MedalService {
	@Autowired
	private MedalDao medalDao;
	
	@Override
	public MedalDO get(Long id){
		return medalDao.get(id);
	}
	
	@Override
	public List<MedalDO> list(Map<String, Object> map){
		return medalDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return medalDao.count(map);
	}
	
	@Override
	public int save(MedalDO medal){
		return medalDao.save(medal);
	}
	
	@Override
	public int update(MedalDO medal){
		return medalDao.update(medal);
	}
	
	@Override
	public int remove(Long id){
		return medalDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return medalDao.batchRemove(ids);
	}

	@Override
	public boolean boolId(Map<String, Object> params) {
		return medalDao.list(params).size()>0;
	}
	
}

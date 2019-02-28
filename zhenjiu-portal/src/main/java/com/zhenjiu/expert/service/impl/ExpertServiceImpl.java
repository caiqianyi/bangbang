package com.zhenjiu.expert.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenjiu.expert.dao.ExpertDao;
import com.zhenjiu.expert.domain.ExpertDO;
import com.zhenjiu.expert.service.ExpertService;

import java.util.List;
import java.util.Map;





@Service
public class ExpertServiceImpl implements ExpertService {
	@Autowired
	private ExpertDao expertDao;
	
	@Override
	public ExpertDO get(Long id){
		return expertDao.get(id);
	}
	
	@Override
	public List<ExpertDO> list(Map<String, Object> map){
		return expertDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return expertDao.count(map);
	}
	
	@Override
	public int save(ExpertDO expert){
		return expertDao.save(expert);
	}
	
	@Override
	public int update(ExpertDO expert){
		return expertDao.update(expert);
	}
	
	@Override
	public int remove(Long id){
		return expertDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return expertDao.batchRemove(ids);
	}
	
}

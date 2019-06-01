package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.VersionManagementDao;
import com.bangbang.information.domain.VersionManagementDO;
import com.bangbang.information.service.VersionManagementService;

import java.util.List;
import java.util.Map;



@Service
public class VersionManagementServiceImpl implements VersionManagementService {
	@Autowired
	private VersionManagementDao versionManagementDao;
	
	@Override
	public VersionManagementDO get(Integer id){
		return versionManagementDao.get(id);
	}
	
	@Override
	public List<VersionManagementDO> list(Map<String, Object> map){
		return versionManagementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return versionManagementDao.count(map);
	}
	
	@Override
	public int save(VersionManagementDO versionManagement){
		return versionManagementDao.save(versionManagement);
	}
	
	@Override
	public int update(VersionManagementDO versionManagement){
		return versionManagementDao.update(versionManagement);
	}
	
	@Override
	public int remove(Integer id){
		return versionManagementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return versionManagementDao.batchRemove(ids);
	}
	
}

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
}

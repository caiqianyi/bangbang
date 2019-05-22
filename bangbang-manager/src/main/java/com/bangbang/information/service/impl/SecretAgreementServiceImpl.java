package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.SecretAgreementDao;
import com.bangbang.information.domain.SecretAgreementDO;
import com.bangbang.information.service.SecretAgreementService;

import java.util.List;
import java.util.Map;




@Service
public class SecretAgreementServiceImpl implements SecretAgreementService {
	@Autowired
	private SecretAgreementDao secretAgreementDao;
	
	@Override
	public SecretAgreementDO get(Integer id){
		return secretAgreementDao.get(id);
	}
	
	@Override
	public List<SecretAgreementDO> list(Map<String, Object> map){
		return secretAgreementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return secretAgreementDao.count(map);
	}
	
	@Override
	public int save(SecretAgreementDO secretAgreement){
		return secretAgreementDao.save(secretAgreement);
	}
	
	@Override
	public int update(SecretAgreementDO secretAgreement){
		return secretAgreementDao.update(secretAgreement);
	}
	
	@Override
	public int remove(Integer id){
		return secretAgreementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return secretAgreementDao.batchRemove(ids);
	}
	
}

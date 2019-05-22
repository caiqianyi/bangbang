package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.RegisterAgreementDao;
import com.bangbang.information.domain.RegisterAgreementDO;
import com.bangbang.information.service.RegisterAgreementService;

import java.util.List;
import java.util.Map;




@Service
public class RegisterAgreementServiceImpl implements RegisterAgreementService {
	@Autowired
	private RegisterAgreementDao registerAgreementDao;
	
	@Override
	public RegisterAgreementDO get(Integer id){
		return registerAgreementDao.get(id);
	}
	
	@Override
	public List<RegisterAgreementDO> list(Map<String, Object> map){
		return registerAgreementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return registerAgreementDao.count(map);
	}
	
	@Override
	public int save(RegisterAgreementDO registerAgreement){
		return registerAgreementDao.save(registerAgreement);
	}
	
	@Override
	public int update(RegisterAgreementDO registerAgreement){
		return registerAgreementDao.update(registerAgreement);
	}
	
	@Override
	public int remove(Integer id){
		return registerAgreementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return registerAgreementDao.batchRemove(ids);
	}
	
}

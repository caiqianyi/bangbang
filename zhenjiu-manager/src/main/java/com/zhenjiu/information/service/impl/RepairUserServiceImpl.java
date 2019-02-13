package com.zhenjiu.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zhenjiu.information.dao.RepairUserDao;
import com.zhenjiu.information.domain.RepairUserDO;
import com.zhenjiu.information.service.RepairUserService;



@Service
public class RepairUserServiceImpl implements RepairUserService {
	@Autowired
	private RepairUserDao repairUserDao;
	
	@Override
	public RepairUserDO get(Integer id){
		return repairUserDao.get(id);
	}
	
	@Override
	public List<RepairUserDO> list(Map<String, Object> map){
		return repairUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return repairUserDao.count(map);
	}
	
	@Override
	public int save(RepairUserDO repairUser){
		return repairUserDao.save(repairUser);
	}
	
	@Override
	public int update(RepairUserDO repairUser){
		return repairUserDao.update(repairUser);
	}
	
	@Override
	public int remove(Integer id){
		return repairUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return repairUserDao.batchRemove(ids);
	}
	
}

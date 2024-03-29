package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.common.utils.Query;
import com.bangbang.information.dao.ReedeemDao;
import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SendoutReedeemDO;
import com.bangbang.information.service.ReedeemService;

import java.util.List;
import java.util.Map;





@Service
public class ReedeemServiceImpl implements ReedeemService {
	@Autowired
	private ReedeemDao reedeemDao;
	
	@Override
	public ReedeemDO get(Long id){
		return reedeemDao.get(id);
	}
	
	@Override
	public List<ReedeemDO> list(Map<String, Object> map){
		return reedeemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return reedeemDao.count(map);
	}
	
	@Override
	public int save(ReedeemDO reedeem){
		return reedeemDao.save(reedeem);
	}
	
	@Override
	public int update(ReedeemDO reedeem){
		return reedeemDao.update(reedeem);
	}
	
	@Override
	public int remove(Long id){
		return reedeemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return reedeemDao.batchRemove(ids);
	}

	@Override
	public void updateByReemId(Long id, int length) {
		reedeemDao.updateByReemId(id,length);
	}

	@Override
	public int savelist(List<ReedeemDO> list) {
		return reedeemDao.savelist(list);
	}
	
	@Override
	public List<CouponDO> getCoupon() {
		return reedeemDao.getCoupon();
	}

	@Override

	public List<ReedeemDO> duihuanyonghulist(Map<String, Object> params) {
		return reedeemDao.duihuanyonghulist(params);
	}

	@Override
	public List<SendoutReedeemDO> userreedeemlist(Map<String,Object> map) {
		return reedeemDao.userreedeemlist(map);
	}
	public List<Map<String, Object>> exeList(Map<String, Object> map) {
		return reedeemDao.exeList(map);

	}
}

package com.zhenjiu.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zhenjiu.information.dao.GoodsResourcesDao;
import com.zhenjiu.information.dao.OrderDao;
import com.zhenjiu.information.domain.GoodsResourcesDO;
import com.zhenjiu.information.domain.OrderDO;
import com.zhenjiu.information.service.GoodsResourcesService;
import com.zhenjiu.information.service.OrderService;



@Service
public class GoodsResourcesServiceImpl implements GoodsResourcesService {
	@Autowired
	private GoodsResourcesDao goodsResourcesDao;
	
	@Override
	public GoodsResourcesDO get(Integer id){
		return goodsResourcesDao.get(id);
	}
	
	@Override
	public List<GoodsResourcesDO> list(Map<String, Object> map){
		return goodsResourcesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return goodsResourcesDao.count(map);
	}
	
	@Override
	public int save(GoodsResourcesDO goodsResourcesDO){
		return goodsResourcesDao.save(goodsResourcesDO);
	}
	
	@Override
	public int update(GoodsResourcesDO goodsResourcesDO){
		return goodsResourcesDao.update(goodsResourcesDO);
	}
	
	@Override
	public int remove(Integer id){
		return goodsResourcesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return goodsResourcesDao.batchRemove(ids);
	}

//	@Override
//	public List<Map<String, Object>> listData(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int countData(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
}
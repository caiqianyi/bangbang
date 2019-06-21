package com.bangbang.wepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.wepay.dao.OrderDao;
import com.bangbang.wepay.domain.OrderDO;
import com.bangbang.wepay.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}
	

	@Override
	public OrderDO getbyno(String no) {
		return orderDao.get(no);
	}
	
}

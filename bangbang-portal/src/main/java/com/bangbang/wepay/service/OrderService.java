package com.bangbang.wepay.service;


import java.util.List;
import java.util.Map;

import com.bangbang.wepay.domain.OrderDO;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 14:33:26
 */
public interface OrderService {
	int save(OrderDO order);
	int update(OrderDO order);
	OrderDO getbyno(String tno);
}

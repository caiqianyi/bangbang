package com.bangbang.wepay.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.wepay.domain.OrderDO;


/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-19 14:33:26
 */
@Mapper
public interface OrderDao {

	OrderDO get(String no);
	
	List<OrderDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

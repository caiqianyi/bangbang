package com.dingshi.information.service;

import com.dingshi.information.domain.GoodsResourcesDO;
import com.dingshi.information.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 货源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-09-27 10:21:16
 */
public interface GoodsResourcesService {
	
	GoodsResourcesDO get(Integer id);
	
	List<GoodsResourcesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GoodsResourcesDO goodsResourcesDO);
	
	int update(GoodsResourcesDO goodsResourcesDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

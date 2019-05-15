package com.bangbang.information.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.information.domain.SendoutReedeemDO;

/**
 * 兑换码发放表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 15:32:01
 */
@Mapper
public interface SendoutReedeemDao {

	SendoutReedeemDO get(Long id);
	
	List<SendoutReedeemDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SendoutReedeemDO reedeem);
	
	int update(SendoutReedeemDO reedeem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

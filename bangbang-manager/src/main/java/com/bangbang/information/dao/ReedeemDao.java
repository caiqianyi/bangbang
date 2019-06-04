package com.bangbang.information.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SendoutReedeemDO;

/**
 * 兑换码表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 13:35:00
 */
@Mapper
public interface ReedeemDao {

	ReedeemDO get(Long id);
	
	List<ReedeemDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ReedeemDO reedeem);
	
	int update(ReedeemDO reedeem);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	void updateByReemId(@Param("id") Long id, @Param("length") int length);

	int savelist(List<ReedeemDO> list);
	List<CouponDO> getCoupon();

	List<ReedeemDO> duihuanyonghulist(Map<String, Object> params);

	List<SendoutReedeemDO> userreedeemlist(Map<String, Object> map);
}

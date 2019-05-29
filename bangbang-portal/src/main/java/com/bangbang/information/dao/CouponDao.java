package com.bangbang.information.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bangbang.information.domain.CouponDO;
import com.bangbang.information.domain.ReedeemDO;

@Mapper
public interface CouponDao {

	List<CouponDO> listCoupon(long id);

	ReedeemDO getReedeem(@Param("id") Long id, @Param("reedeemCode") String reedeemCode);

	Object updateReedeemIfUsed(@Param("id") Long id,@Param("reedeemCode") String reedeemCode);

}

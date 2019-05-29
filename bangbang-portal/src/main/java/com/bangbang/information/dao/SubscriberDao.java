package com.bangbang.information.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bangbang.information.domain.SubscriberDO;

@Mapper
public interface SubscriberDao {

	SubscriberDO getInfo(String phone);

	int updateNickname(@Param("id") Long id, @Param("nickname")String nickname);

	int updatePhone(@Param("id") Long id, @Param("phone") String phone);

	int updateSignName(@Param("id") Long id, @Param("signName") String signName);

	int updateBirthday(@Param("id") Long id, @Param("birthday") Date birthday);

	int updateSex(@Param("id") Long id,@Param("sex") Integer sex);

	int updateHeadUrl(@Param("id") Long id, @Param("headUrl") String headUrl);

	/*int update(SubscriberDO subscriberDO);*/
}

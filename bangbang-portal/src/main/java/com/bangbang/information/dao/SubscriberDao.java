package com.bangbang.information.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bangbang.information.domain.ChartData;
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
	void updateStudyTime(@Param("userId") Long userId,@Param("playedTime") long playedTime);

	void updateIfContinue(@Param("userId") Long userId, @Param("createTime") Date createTime);

	List<ChartData> getDaysPlayedTime(@Param("userId") Long userId, @Param("date1") Date date1, @Param("date2") Date date2);
}

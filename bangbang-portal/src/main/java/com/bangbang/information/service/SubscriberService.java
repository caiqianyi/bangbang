package com.bangbang.information.service;

import java.util.Date;
import java.util.List;

import com.bangbang.information.domain.ChartData;
import com.bangbang.information.domain.SubscriberDO;

public interface SubscriberService {

	SubscriberDO getInfo(String phone);

	int updateNickname(Long id, String nickname);

	int updatePhone(Long id, String phone);

	int updateSignName(Long id, String signName);

	int updateBirthday(Long id, Date birthday);

	int updateSex(Long id, Integer sex);

	int updateHeadUrl(Long id, String string);

	void updateStudyTime(long playedTime, Long userId);

	void updateIfContinue(Long userId, Date createTime);

	List<ChartData> getDaysPlayedTime(Long userId, Date date1, Date date2);

}

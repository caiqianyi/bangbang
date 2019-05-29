package com.bangbang.information.service;

import java.util.Date;

import com.bangbang.information.domain.SubscriberDO;

public interface SubscriberService {

	SubscriberDO getInfo(String phone);

	int updateNickname(Long id, String nickname);

	int updatePhone(Long id, String phone);

	int updateSignName(Long id, String signName);

	int updateBirthday(Long id, Date birthday);

	int updateSex(Long id, Integer sex);

	int updateHeadUrl(Long id, String string);

}

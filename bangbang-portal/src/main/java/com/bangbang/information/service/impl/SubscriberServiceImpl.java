package com.bangbang.information.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangbang.information.dao.SubscriberDao;
import com.bangbang.information.domain.ChartData;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubscriberService;

@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService{

	@Autowired
	private SubscriberDao subscriberDao;
	@Override
	public SubscriberDO getInfo(String phone) {
		return subscriberDao.getInfo(phone);
	}
	@Override
	public int updateNickname(Long id, String nickname) {
		return subscriberDao.updateNickname(id,nickname);
	}
	@Override
	public int updatePhone(Long id, String phone) {
		return subscriberDao.updatePhone(id,phone);
	}
	@Override
	public int updateSignName(Long id, String signName) {
		return subscriberDao.updateSignName(id,signName);
	}
	@Override
	public int updateBirthday(Long id, Date birthday) {
		return subscriberDao.updateBirthday(id,birthday);
	}
	@Override
	public int updateSex(Long id, Integer sex) {
		return subscriberDao.updateSex(id,sex);
	}
	@Override
	public int updateHeadUrl(Long id, String headUrl) {
		return subscriberDao.updateHeadUrl(id,headUrl);
	}
	@Override
	public void updateStudyTime(long playedTime, Long userId) {
		subscriberDao.updateStudyTime(userId,playedTime);
	}
	@Override
	public void updateIfContinue(Long userId, Date createTime) {
		subscriberDao.updateIfContinue(userId,createTime);
	}
	@Override
	public List<ChartData> getDaysPlayedTime(Long userId, Date date1, Date date2) {
		return subscriberDao.getDaysPlayedTime(userId,date1,date2);
	}
}

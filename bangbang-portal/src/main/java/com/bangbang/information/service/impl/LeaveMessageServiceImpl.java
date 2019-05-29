package com.bangbang.information.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangbang.information.dao.LeaveMessageDao;
import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.service.LeaveMessageService;

@Service
@Transactional
public class LeaveMessageServiceImpl implements LeaveMessageService{

	private LeaveMessageDao leaveMessageDao;
	@Override
	public int saveLeaveMessage(LeaveMessageDO leaveMessageDO) {
		
		return leaveMessageDao.saveLeaveMessage(leaveMessageDO);
	}
	@Override
	public List<LeaveMessageDO> getAllLeaveMessage(Long id) {
		
		return leaveMessageDao.getAllLeaveMessage(id);
	}
	@Override
	public List<QuestioneAnswersDO> getAllQuestioneAnswers(Long id) {
		return leaveMessageDao.getAllQuestioneAnswers(id);
	}

}

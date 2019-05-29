package com.bangbang.information.service;

import java.util.List;

import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.QuestioneAnswersDO;

public interface LeaveMessageService {

	int saveLeaveMessage(LeaveMessageDO leaveMessageDO);

	List<LeaveMessageDO> getAllLeaveMessage(Long id);

	List<QuestioneAnswersDO> getAllQuestioneAnswers(Long id);

}

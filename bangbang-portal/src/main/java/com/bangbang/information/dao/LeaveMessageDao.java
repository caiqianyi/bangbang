package com.bangbang.information.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.QuestioneAnswersDO;

@Mapper
public interface LeaveMessageDao {

	int saveLeaveMessage(LeaveMessageDO leaveMessageDO);

	List<LeaveMessageDO> getAllLeaveMessage(Long id);

	List<QuestioneAnswersDO> getAllQuestioneAnswers(Long id);

}

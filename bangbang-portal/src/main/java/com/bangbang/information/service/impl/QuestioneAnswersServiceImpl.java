package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.QuestioneAnswersDao;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.service.QuestioneAnswersService;

import java.util.List;
import java.util.Map;




@Service
public class QuestioneAnswersServiceImpl implements QuestioneAnswersService {
	@Autowired
	private QuestioneAnswersDao questioneAnswersDao;
	
	@Override
	public QuestioneAnswersDO get(Long id){
		return questioneAnswersDao.get(id);
	}
	
	@Override
	public List<QuestioneAnswersDO> list(Map<String, Object> map){
		return questioneAnswersDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questioneAnswersDao.count(map);
	}
	
	@Override
	public int save(QuestioneAnswersDO questioneAnswers){
		return questioneAnswersDao.save(questioneAnswers);
	}
	
	@Override
	public int update(QuestioneAnswersDO questioneAnswers){
		return questioneAnswersDao.update(questioneAnswers);
	}
	
	@Override
	public int remove(Long id){
		return questioneAnswersDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return questioneAnswersDao.batchRemove(ids);
	}

	
}

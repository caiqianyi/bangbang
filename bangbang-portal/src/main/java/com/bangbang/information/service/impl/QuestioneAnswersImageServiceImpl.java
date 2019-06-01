package com.bangbang.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.information.dao.QuestioneAnswersImageDao;
import com.bangbang.information.domain.QuestioneAnswersImageDO;
import com.bangbang.information.service.QuestioneAnswersImageService;

import java.util.List;
import java.util.Map;




@Service
public class QuestioneAnswersImageServiceImpl implements QuestioneAnswersImageService {
	@Autowired
	private QuestioneAnswersImageDao questioneAnswersImageDao;
	
	@Override
	public QuestioneAnswersImageDO get(Integer id){
		return questioneAnswersImageDao.get(id);
	}
	
	@Override
	public List<QuestioneAnswersImageDO> list(Map<String, Object> map){
		return questioneAnswersImageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questioneAnswersImageDao.count(map);
	}
	
	@Override
	public int save(QuestioneAnswersImageDO questioneAnswersImage){
		return questioneAnswersImageDao.save(questioneAnswersImage);
	}
	
	@Override
	public int update(QuestioneAnswersImageDO questioneAnswersImage){
		return questioneAnswersImageDao.update(questioneAnswersImage);
	}
	
	@Override
	public int remove(Integer id){
		return questioneAnswersImageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return questioneAnswersImageDao.batchRemove(ids);
	}
	
}

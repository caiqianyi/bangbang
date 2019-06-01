package com.bangbang.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.course.dao.QuestionsMoneyNotesDao;
import com.bangbang.course.domain.QuestionsMoneyNotesDO;
import com.bangbang.course.service.QuestionsMoneyNotesService;
import com.bangbang.information.domain.QuestioneAnswersDO;

import java.util.List;
import java.util.Map;





@Service
public class QuestionsMoneyNotesServiceImpl implements QuestionsMoneyNotesService {
	@Autowired
	private QuestionsMoneyNotesDao questionsMoneyNotesDao;
	
	@Override
	public QuestionsMoneyNotesDO get(Long id){
		return questionsMoneyNotesDao.get(id);
	}
	
	@Override
	public List<QuestionsMoneyNotesDO> list(Map<String, Object> map){
		return questionsMoneyNotesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return questionsMoneyNotesDao.count(map);
	}
	
	@Override
	public int save(QuestionsMoneyNotesDO questionsMoneyNotes){
		return questionsMoneyNotesDao.save(questionsMoneyNotes);
	}
	
	@Override
	public int update(QuestionsMoneyNotesDO questionsMoneyNotes){
		return questionsMoneyNotesDao.update(questionsMoneyNotes);
	}
	
	@Override
	public int remove(Long id){
		return questionsMoneyNotesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return questionsMoneyNotesDao.batchRemove(ids);
	}
	
}

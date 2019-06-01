package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.domain.QuestionsMoneyNotesDO;

/**
 * 课程问答金额和说明表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public interface QuestionsMoneyNotesService {
	
	QuestionsMoneyNotesDO get(Long id);
	
	List<QuestionsMoneyNotesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QuestionsMoneyNotesDO questionsMoneyNotes);
	
	int update(QuestionsMoneyNotesDO questionsMoneyNotes);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
}

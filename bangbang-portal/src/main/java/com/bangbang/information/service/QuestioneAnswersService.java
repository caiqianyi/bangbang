package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.QuestioneAnswersDO;

/**
 * 问答表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 19:00:44
 */
public interface QuestioneAnswersService {
	
	QuestioneAnswersDO get(Long id);
	
	List<QuestioneAnswersDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QuestioneAnswersDO questioneAnswers);
	
	int update(QuestioneAnswersDO questioneAnswers);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	

}

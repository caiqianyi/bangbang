package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.QuestioneAnswersImageDO;

/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-30 11:24:24
 */
public interface QuestioneAnswersImageService {
	
	QuestioneAnswersImageDO get(Integer id);
	
	List<QuestioneAnswersImageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QuestioneAnswersImageDO questioneAnswersImage);
	
	int update(QuestioneAnswersImageDO questioneAnswersImage);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

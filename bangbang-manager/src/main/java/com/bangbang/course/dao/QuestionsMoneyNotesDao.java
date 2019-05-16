package com.bangbang.course.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.course.domain.QuestionsMoneyNotesDO;

/**
 * 课程问答金额和说明表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
@Mapper
public interface QuestionsMoneyNotesDao {

	QuestionsMoneyNotesDO get(Long id);
	
	List<QuestionsMoneyNotesDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(QuestionsMoneyNotesDO questionsMoneyNotes);
	
	int update(QuestionsMoneyNotesDO questionsMoneyNotes);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

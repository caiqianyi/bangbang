package com.bangbang.teacher.service;


import java.util.List;
import java.util.Map;

import com.bangbang.teacher.domain.TeacherDO;

/**
 * 讲师表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 09:37:37
 */
public interface TeacherService {
	
	TeacherDO get(Long id);
	
	List<TeacherDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeacherDO teacher);
	
	int update(TeacherDO teacher);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<TeacherDO> queryTeacherName(Map<String,Object> map);
	
	TeacherDO queryTeacherId(String name);
	
	List<Map<String,Object>> queryQuestioneMoney(Long id);


}

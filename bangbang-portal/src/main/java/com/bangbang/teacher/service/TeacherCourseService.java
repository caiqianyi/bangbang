package com.bangbang.teacher.service;


import java.util.List;
import java.util.Map;

import com.bangbang.teacher.domain.TeacherCourseDO;

/**
 * 讲师课程中间表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 11:54:01
 */
public interface TeacherCourseService {
	
	TeacherCourseDO get(Long id);
	
	List<TeacherCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeacherCourseDO teacherCourse);
	
	int update(TeacherCourseDO teacherCourse);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
}

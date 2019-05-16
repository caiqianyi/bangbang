package com.bangbang.teacher.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.teacher.domain.TeacherCourseDO;

/**
 * 讲师课程中间表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 11:54:01
 */
@Mapper
public interface TeacherCourseDao {

	TeacherCourseDO get(Long id);
	
	List<TeacherCourseDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TeacherCourseDO teacherCourse);
	
	int update(TeacherCourseDO teacherCourse);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

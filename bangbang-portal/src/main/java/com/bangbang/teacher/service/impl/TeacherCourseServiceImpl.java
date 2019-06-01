package com.bangbang.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.teacher.dao.TeacherCourseDao;
import com.bangbang.teacher.domain.TeacherCourseDO;
import com.bangbang.teacher.service.TeacherCourseService;

import java.util.List;
import java.util.Map;




@Service
public class TeacherCourseServiceImpl implements TeacherCourseService {
	@Autowired
	private TeacherCourseDao teacherCourseDao;
	
	@Override
	public TeacherCourseDO get(Long id){
		return teacherCourseDao.get(id);
	}
	
	@Override
	public List<TeacherCourseDO> list(Map<String, Object> map){
		return teacherCourseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return teacherCourseDao.count(map);
	}
	
	@Override
	public int save(TeacherCourseDO teacherCourse){
		return teacherCourseDao.save(teacherCourse);
	}
	
	@Override
	public int update(TeacherCourseDO teacherCourse){
		return teacherCourseDao.update(teacherCourse);
	}
	
	@Override
	public int remove(Long id){
		return teacherCourseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return teacherCourseDao.batchRemove(ids);
	}

	
}

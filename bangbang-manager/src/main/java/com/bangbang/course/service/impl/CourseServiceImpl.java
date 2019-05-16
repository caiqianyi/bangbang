package com.bangbang.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.course.dao.CourseDao;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseService;

import java.util.List;
import java.util.Map;





@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public CourseDO get(Long id){
		return courseDao.get(id);
	}
	
	@Override
	public List<CourseDO> list(Map<String, Object> map){
		return courseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseDao.count(map);
	}
	
	@Override
	public int save(CourseDO course){
		return courseDao.save(course);
	}
	
	@Override
	public int update(CourseDO course){
		return courseDao.update(course);
	}
	
	@Override
	public int remove(Long id){
		return courseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return courseDao.batchRemove(ids);
	}

	@Override
	public boolean boolId(Map<String, Object> map) {
		return courseDao.list(map).size()>0;
	}

	@Override
	public CourseDO getId(Long id) {
		return courseDao.getId(id);
	}

	@Override
	public List<CourseDO> teacherC(Long id) {
		return courseDao.teacherC(id);
	}
	
}

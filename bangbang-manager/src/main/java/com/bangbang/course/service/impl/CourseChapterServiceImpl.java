package com.bangbang.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.course.dao.CourseChapterDao;
import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseChapterService;

import java.util.List;
import java.util.Map;





@Service
public class CourseChapterServiceImpl implements CourseChapterService {
	@Autowired
	private CourseChapterDao courseChapterDao;
	
	@Override
	public CourseChapterDO get(Long id){
		return courseChapterDao.get(id);
	}
	
	@Override
	public List<CourseChapterDO> list(Map<String, Object> map){
		return courseChapterDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseChapterDao.count(map);
	}
	
	@Override
	public int save(CourseChapterDO courseChapter){
		return courseChapterDao.save(courseChapter);
	}
	
	@Override
	public int update(CourseChapterDO courseChapter){
		return courseChapterDao.update(courseChapter);
	}
	
	@Override
	public int remove(Long id){
		return courseChapterDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return courseChapterDao.batchRemove(ids);
	}

	@Override
	public List<CourseChapterDO> queryCId(Long courseId) {
		return courseChapterDao.queryCId(courseId);
	}

	@Override
	public int queryCourse(Long courseId) {
		return courseChapterDao.queryCourse(courseId);
	}

	@Override
	public CourseChapterDO queryCtag() {
		return courseChapterDao.queryCtag();
	}

	@Override
	public void deleteZJ() {
		courseChapterDao.deleteZJ();
	}
	
}

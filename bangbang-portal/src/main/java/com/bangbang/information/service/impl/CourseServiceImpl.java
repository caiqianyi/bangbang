package com.bangbang.information.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangbang.information.dao.CourseDao;
import com.bangbang.information.domain.CourseChapterDO;
import com.bangbang.information.domain.CourseDO;
import com.bangbang.information.domain.CourseSortDO;
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.service.CourseServcie;

@Service
@Transactional
public class CourseServiceImpl implements CourseServcie{

	@Autowired
	private CourseDao courseDao;
	@Override
	public List<CourseSortDO> getAllCourseSort() {
		return courseDao.getAllCourseSort();
	}
	@Override
	public List<CourseDO> getAllCourseBySortId(Long id) {
		return courseDao.getAllCourseBySortId(id);
	}
	@Override
	public List<SubcriberLogDO> getAllCourseByFlag(Map<String,Object> params) {
		return courseDao.getAllCourseByFlag(params);
	}
	@Override
	public List<PlayRecordDO> getPlayRecord(Map<String,Object> params) {
		return courseDao.getPlayRecord(params);
	}
	@Override
	public List<CourseChapterDO> getCourseCharacterByCourseId(Long courseId) {
		return courseDao.getCourseCharacterByCourseId(courseId);
	}
	@Override
	public PlayRecordDO getPlayRecordByUserIdAndCourseId(Long courseId, Long userId) {
		return courseDao.getPlayRecordByUserIdAndCourseId(courseId,userId);
	}
	@Override
	public int saveSubcriberLog(SubcriberLogDO subcriberLogDO) {
		
		return courseDao.saveSubcriberLog(subcriberLogDO);
	}
	@Override
	public CourseDO getCourseByCourseId(Long courseId) {
		
		return courseDao.getCourseByCourseId(courseId);
	}
	@Override
	public void savePlayRecord(PlayRecordDO playRecordDO) {
		courseDao.savePlayRecord(playRecordDO);
	}
	@Override
	public PlayRecordDO getLastPlayRecord(Long userId) {
		return courseDao.getLastPlayRecord(userId);
	}
	@Override
	public List<CourseDO> getCourseDim(String input) {
		return courseDao.getCourseDim(input);
	}
	
}

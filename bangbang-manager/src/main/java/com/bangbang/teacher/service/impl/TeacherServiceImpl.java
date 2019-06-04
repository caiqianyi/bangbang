package com.bangbang.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.teacher.dao.TeacherDao;
import com.bangbang.teacher.domain.TeacherDO;
import com.bangbang.teacher.service.TeacherService;

import java.util.List;
import java.util.Map;





@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public TeacherDO get(Long id){
		return teacherDao.get(id);
	}
	
	@Override
	public List<TeacherDO> list(Map<String, Object> map){
		return teacherDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return teacherDao.count(map);
	}
	
	@Override
	public int save(TeacherDO teacher){
		return teacherDao.save(teacher);
	}
	
	@Override
	public int update(TeacherDO teacher){
		return teacherDao.update(teacher);
	}
	
	@Override
	public int remove(Long id){
		return teacherDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return teacherDao.batchRemove(ids);
	}

	@Override
	public List<TeacherDO> queryTeacherName(Map<String, Object> map) {
		return teacherDao.queryTeacherName(map);
	}

	@Override
	public TeacherDO queryTeacherId(String name) {
		return teacherDao.queryTeacherId(name);
	}

	@Override
	public List<Map<String, Object>> queryQuestioneMoney(Long id) {
		return teacherDao.queryQuestioneMoney(id);
	}
	
}

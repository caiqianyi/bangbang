package com.bangbang.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.course.dao.CourseSortDao;
import com.bangbang.course.domain.CourseSortDO;
import com.bangbang.course.service.CourseSortService;

import java.util.List;
import java.util.Map;





@Service
public class CourseSortServiceImpl implements CourseSortService {
	@Autowired
	private CourseSortDao courseSortDao;
	
	@Override
	public CourseSortDO get(Long id){
		return courseSortDao.get(id);
	}
	
	@Override
	public List<CourseSortDO> list(Map<String, Object> map){
		return courseSortDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseSortDao.count(map);
	}
	
	@Override
	public int save(CourseSortDO courseSort){
		return courseSortDao.save(courseSort);
	}
	
	@Override
	public int update(CourseSortDO courseSort){
		return courseSortDao.update(courseSort);
	}
	
	@Override
	public int remove(Long id){
		return courseSortDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return courseSortDao.batchRemove(ids);
	}

	@Override
	public List<CourseSortDO> queryName(Map<String, Object> map) {
		return courseSortDao.queryName(map);
	}

	@Override
	public boolean boolName(Map<String, Object> params) {
		return courseSortDao.list(params).size()>0;
	}
	
}

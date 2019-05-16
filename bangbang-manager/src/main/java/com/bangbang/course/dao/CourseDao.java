package com.bangbang.course.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.course.domain.CourseDO;

/**
 * 课程表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
@Mapper
public interface CourseDao {

	CourseDO get(Long id);
	
	List<CourseDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CourseDO course);
	
	int update(CourseDO course);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	boolean boolId(Map<String,Object> map);
	
	CourseDO getId(Long id);
	
	List<CourseDO> teacherC(Long id);
}

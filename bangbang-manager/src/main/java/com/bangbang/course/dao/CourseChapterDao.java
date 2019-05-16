package com.bangbang.course.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;

/**
 * 课程章节
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
@Mapper
public interface CourseChapterDao {

	CourseChapterDO get(Long id);
	
	List<CourseChapterDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CourseChapterDO courseChapter);
	
	int update(CourseChapterDO courseChapter);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<CourseChapterDO> queryCId(Long courseId);
	
}

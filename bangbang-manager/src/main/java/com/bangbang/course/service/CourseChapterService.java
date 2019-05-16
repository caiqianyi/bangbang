package com.bangbang.course.service;


import java.util.List;
import java.util.Map;

import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;

/**
 * 课程章节
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public interface CourseChapterService {
	
	CourseChapterDO get(Long id);
	
	List<CourseChapterDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseChapterDO courseChapter);
	
	int update(CourseChapterDO courseChapter);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<CourseChapterDO> queryCId(Long courseId);

}

package com.bangbang.course.service;


import java.util.List;
import java.util.Map;

import com.bangbang.course.domain.CourseSortDO;

/**
 * 课程分类列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
public interface CourseSortService {
	
	CourseSortDO get(Long id);
	
	List<CourseSortDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseSortDO courseSort);
	
	int update(CourseSortDO courseSort);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	List<CourseSortDO> queryName(Map<String,Object> map);
	
	boolean boolName(Map<String,Object> params);

}

package com.bangbang.teacher.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.teacher.domain.TeacherDO;

/**
 * 讲师表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 09:37:37
 */
@Mapper
public interface TeacherDao {

	TeacherDO get(Long id);
	
	List<TeacherDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TeacherDO teacher);
	
	int update(TeacherDO teacher);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
		
	TeacherDO getHeadUrl(String name);
	
	List<Map<String,Object>> getTeacherQA(Long id);
}

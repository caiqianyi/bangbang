package com.bangbang.information.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bangbang.information.domain.CourseChapterDO;
import com.bangbang.information.domain.CourseDO;
import com.bangbang.information.domain.CourseSortDO;
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.domain.SubcriberLogDO;

@Mapper
public interface CourseDao {

	List<CourseSortDO> getAllCourseSort();

	List<CourseDO> getAllCourseBySortId(Long id);

	List<SubcriberLogDO> getAllCourseByFlag(Map<String,Object> params);

	List<PlayRecordDO> getPlayRecord(Map<String,Object> params);

	List<CourseChapterDO> getCourseCharacterByCourseId(Long courseId);

	PlayRecordDO getPlayRecordByUserIdAndCourseId(@Param("courseId") Long courseId,@Param("userId")  Long userId);

	List<SubcriberLogDO> getBuyedCourse(Long userId);

	int saveSubcriberLog(SubcriberLogDO subcriberLogDO);

	CourseDO getCourseByCourseId(Long courseId);



}

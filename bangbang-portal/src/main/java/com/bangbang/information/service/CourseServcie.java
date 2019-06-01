package com.bangbang.information.service;

import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.CourseChapterDO;
import com.bangbang.information.domain.CourseDO;
import com.bangbang.information.domain.CourseSortDO;
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.domain.SubcriberLogDO;

public interface CourseServcie {

	List<CourseSortDO> getAllCourseSort();

	List<CourseDO> getAllCourseBySortId(Long id);

	List<SubcriberLogDO> getAllCourseByFlag(Map<String,Object> params);

	List<PlayRecordDO> getPlayRecord(Map<String,Object> params);

	List<CourseChapterDO> getCourseCharacterByCourseId(Long courseId);

	PlayRecordDO getPlayRecordByUserIdAndCourseId(Long courseId, Long userId);

	int saveSubcriberLog(SubcriberLogDO subcriberLogDO);

	CourseDO getCourseByCourseId(Long courseId);

	
}

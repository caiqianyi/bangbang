package com.bangbang.course.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.OssUtils;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.domain.CourseSortDO;
import com.bangbang.course.domain.QuestionsMoneyNotesDO;
import com.bangbang.course.service.CourseChapterService;
import com.bangbang.course.service.CourseService;
import com.bangbang.course.service.CourseSortService;
import com.bangbang.course.service.QuestionsMoneyNotesService;
import com.bangbang.owneruser.comment.GenerateCode;
import com.bangbang.teacher.domain.TeacherCourseDO;
import com.bangbang.teacher.domain.TeacherDO;
import com.bangbang.teacher.service.TeacherCourseService;
import com.bangbang.teacher.service.TeacherService;



/**
 * 课程表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
 
@Controller
@RequestMapping("/information/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseSortService courseSortService;
	@Autowired
	private QuestionsMoneyNotesService questionsMoneyNotesService;
	@Autowired
	private CourseChapterService courseChapterService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherCourseService teacherCourseService;

	
	@GetMapping()
	@RequiresPermissions("information:course:course")
	String Course(Map<String, Object> map,Model model){
		List<CourseSortDO> listSort = courseSortService.list(map);
		model.addAttribute("listSort", listSort);
	    return "course/course/course";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:course:course")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseDO> courseList = courseService.list(query);
		int total = courseService.count(query);
		PageUtils pageUtils = new PageUtils(courseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:course:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map", map);
		List<CourseSortDO> courseName = courseSortService.queryName(map);
		Map<String, Object> mapP = new HashMap<String, Object>();
		mapP.put("mapP", mapP);
		List<TeacherDO> teacherName = teacherService.queryTeacherName(mapP);
		model.addAttribute("courseName", courseName);
		model.addAttribute("teacherName", teacherName);
	    return "course/course/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:course:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CourseDO course = courseService.get(id);
		QuestionsMoneyNotesDO questionsMN = questionsMoneyNotesService.get(id);		
		Map<String, Object> mapP = new HashMap<String, Object>();
		mapP.put("mapP", mapP);
		List<TeacherDO> teacherName = teacherService.queryTeacherName(mapP);
		model.addAttribute("questionsMN", questionsMN);
		model.addAttribute("course", course);
		model.addAttribute("teacherName", teacherName);
	    return "course/course/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:course:add")
	public R save( CourseDO course,Long courseId,QuestionsMoneyNotesDO qmn){
		MultipartFile imgFile = course.getImgFile();
		String fileName = imgFile.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);		
		try {	
			OssUtils ossUtils=new OssUtils(fileName);
	        String headurl =  ossUtils.uploadObject(imgFile);
			//FileUtil.uploadFile(course.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
			course.setCourseCover(headurl);
			course.setAddTime(new Date());
		} catch (Exception e) {
			return R.error();
		}
		Long cId = GenerateCode.gen16(6);
		course.setCourseId(cId);
		course.setChapterNum(0);
		String teacher2 = course.getTeacher();
		if(teacher2 == null || teacher2.equals("")){
			return R.error("请选择老师");
		}
		if(courseService.save(course)>0){
			qmn.setId(course.getId());
			qmn.setCourseSort(course.getCourseName());
			qmn.setCourseId(course.getCourseId());
			qmn.setName(course.getName());
			qmn.setQuestionsTeacher(course.getQuestionsTeacher());
			questionsMoneyNotesService.save(qmn);			
			
			TeacherCourseDO tcDO = new TeacherCourseDO();
			String teacher = course.getTeacher();
			String[] arr = teacher.split(",");
			for (String string : arr) {
				TeacherDO tch = teacherService.queryTeacherId(string);
				Long id = tch.getId();
				//System.out.println(teacherId);
				tcDO.setTeacherId(id);
				tcDO.setCourseId(course.getCourseId());
				teacherCourseService.save(tcDO);
			}									
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:course:edit")
	public R update( CourseDO course,QuestionsMoneyNotesDO qmn,Long id){
		
		if(course.getImgFile() != null && course.getImgFile().getSize() > 0){
			MultipartFile imgFile = course.getImgFile();
			String fileName = imgFile.getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				OssUtils ossUtils=new OssUtils(fileName);
		        String headurl =  ossUtils.uploadObject(imgFile);
				//FileUtil.uploadFile(course.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				course.setCourseCover(headurl);
			} catch (Exception e) {
				return R.error();
			}
		}
		qmn.setId(course.getId());
		qmn.setCourseSort(course.getCourseName());
		qmn.setCourseId(course.getCourseId());
		qmn.setName(course.getName());
		if(qmn.getQuestionsMoney1() == 0){
			qmn.setQuestionsNotes1("");
		}
		if(qmn.getQuestionsMoney2() == 0){
			qmn.setQuestionsNotes2("");
		}
		if(qmn.getQuestionsMoney3() == 0){
			qmn.setQuestionsNotes3("");
		}

		
		CourseDO courseDO = courseService.get(id);
		Long courseId = courseDO.getCourseId();
		List<TeacherCourseDO> queryId = teacherCourseService.queryId(courseId);
		for (TeacherCourseDO teacherCourseDO : queryId) {
			Long tid = teacherCourseDO.getId();
			teacherCourseService.remove(tid);
		}
		TeacherCourseDO tcDO = new TeacherCourseDO();
		String teacher = course.getTeacher();
		String[] arr = teacher.split(",");
		for (String string : arr) {
			TeacherDO tch = teacherService.queryTeacherId(string);
			Long teacherId = tch.getId();
			//System.out.println(teacherId);
			tcDO.setTeacherId(teacherId);
			tcDO.setCourseId(course.getCourseId());
			teacherCourseService.save(tcDO);
		}		
		questionsMoneyNotesService.update(qmn);
		course.setQuestionsTeacher(qmn.getQuestionsTeacher());
		courseService.update(course);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:course:remove")
	public R remove( Long id){
		CourseDO courseDO = courseService.get(id);
		Long courseId = courseDO.getCourseId();
		List<TeacherCourseDO> queryId = teacherCourseService.queryId(courseId);
		for (TeacherCourseDO teacherCourseDO : queryId) {
			Long tid = teacherCourseDO.getId();
			teacherCourseService.remove(tid);
		}
		questionsMoneyNotesService.remove(id);
		if(courseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:course:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		courseService.batchRemove(ids);
		return R.ok();
	}
	
	@GetMapping("/chapter/{id}")
	@RequiresPermissions("information:course:chapter")
	String chapter(@PathVariable("id") Long id,Model model){
		CourseDO course = courseService.getId(id);
		Long courseId = course.getCourseId();
		List<CourseChapterDO> queryCId = courseChapterService.queryCId(courseId);
		model.addAttribute("queryCId", queryCId);
		model.addAttribute("course", course);
	    return "course/course/chapter";
	}

}

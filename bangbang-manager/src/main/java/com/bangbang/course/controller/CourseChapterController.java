package com.bangbang.course.controller;

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

import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseChapterService;
import com.bangbang.course.service.CourseService;


/**
 * 课程章节
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
 
@Controller
@RequestMapping("/information/courseChapter")
public class CourseChapterController {
	@Autowired
	private CourseChapterService courseChapterService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("information:courseChapter:courseChapter")
	String CourseChapter(){
	    return "course/courseChapter/courseChapter";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:courseChapter:courseChapter")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseChapterDO> courseChapterList = courseChapterService.list(query);
		int total = courseChapterService.count(query);
		PageUtils pageUtils = new PageUtils(courseChapterList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{id}")
	@RequiresPermissions("information:courseChapter:add")
	String add(@PathVariable("id")Long id,Model model){
		CourseDO course = courseService.get(id);
		model.addAttribute("course", course);
	    return "course/courseChapter/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:courseChapter:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CourseChapterDO courseChapter = courseChapterService.get(id);
		model.addAttribute("courseChapter", courseChapter);
	    return "course/courseChapter/edit";
	}
	
	@GetMapping("/cha/{id}")
	@RequiresPermissions("information:courseChapter:edit")
	String cha(@PathVariable("id") Long id,Model model){
		CourseChapterDO courseChapter = courseChapterService.get(id);
		model.addAttribute("courseChapter", courseChapter);
	    return "course/courseChapter/cha";
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:courseChapter:add")
	public R save( CourseChapterDO courseChapter){
		
		String fileName = courseChapter.getImgFile().getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);		
		try {					
			FileUtil.uploadFile(courseChapter.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
			courseChapter.setUrl("/files/" + fileName);
			courseChapter.setAddTime(new Date());
		} catch (Exception e) {
			return R.error();
		}
		if(courseChapterService.save(courseChapter)>0){
			Map<String, Object> params = new HashMap<String, Object>();
			Long courseId = courseChapter.getCourseId();
			int courseNum = courseChapterService.queryCourse(courseId);
			params.put("courseId", courseId);
			List<CourseDO> list = courseService.list(params);
			Long id = list.get(0).getId();
			CourseDO course = courseService.get(id);
			course.setChapterNum(courseNum);
			courseService.update(course);
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:courseChapter:edit")
	public R update( CourseChapterDO courseChapter){
		courseChapterService.update(courseChapter);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:courseChapter:remove")
	public R remove( Long id){
		
		CourseChapterDO courseChapter = courseChapterService.get(id);
		Long courseId = courseChapter.getCourseId();
		if(courseChapterService.remove(id)>0){
			int courseNum = courseChapterService.queryCourse(courseId);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("courseId", courseId);
			List<CourseDO> list = courseService.list(params);
			Long ids = list.get(0).getId();
			CourseDO course = courseService.get(ids);
			course.setChapterNum(courseNum);
			courseService.update(course);
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:courseChapter:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		courseChapterService.batchRemove(ids);
		return R.ok();
	}
	
}

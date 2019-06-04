package com.bangbang.teacher.controller;

import java.util.Date;
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
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseService;
import com.bangbang.owneruser.comment.GenerateCode;
import com.bangbang.teacher.domain.TeacherDO;
import com.bangbang.teacher.service.TeacherService;



/**
 * 讲师表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-16 09:37:37
 */
 
@Controller
@RequestMapping("/information/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private CourseService courseService;
	
	@GetMapping()
	@RequiresPermissions("information:teacher:teacher")
	String Teacher(){
	    return "teacher/teacher";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:teacher:teacher")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TeacherDO> teacherList = teacherService.list(query);
		int total = teacherService.count(query);
		PageUtils pageUtils = new PageUtils(teacherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:teacher:add")
	String add(){
	    return "teacher/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:teacher:edit")
	String edit(@PathVariable("id") Long id,Model model){
		TeacherDO teacher = teacherService.get(id);
		model.addAttribute("teacher", teacher);
	    return "teacher/edit";
	}
	@GetMapping("/chakan/{id}")
	@RequiresPermissions("information:teacher:edit")
	String chakan(@PathVariable("id") Long id,Model model){
		TeacherDO teacher = teacherService.get(id);
		List<CourseDO> teacherC = courseService.teacherC(id);
		List<Map<String, Object>> quesMoney = teacherService.queryQuestioneMoney(id);
		model.addAttribute("teacherC", teacherC);
		model.addAttribute("teacher", teacher);
		model.addAttribute("quesMoney", quesMoney);
	    return "teacher/chakan";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:teacher:add")
	public R save( TeacherDO teacher){
		
		String fileName = teacher.getImgFile().getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);		
		try {					
			FileUtil.uploadFile(teacher.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
			teacher.setHeadUrl("/files/" + fileName);
			teacher.setAddTime(new Date());
		} catch (Exception e) {
			return R.error();
		}
		Long teacherAcc = GenerateCode.gen16(8);
		teacher.setTeacherAcc(teacherAcc);
		if(teacherService.save(teacher)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:teacher:edit")
	public R update( TeacherDO teacher){
		if(teacher.getImgFile() != null && teacher.getImgFile().getSize() > 0){
			String fileName = teacher.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(teacher.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				teacher.setHeadUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}
			
		}
		teacherService.update(teacher);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:teacher:remove")
	public R remove( Long id){
		if(teacherService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:teacher:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		teacherService.batchRemove(ids);
		return R.ok();
	}
	
}

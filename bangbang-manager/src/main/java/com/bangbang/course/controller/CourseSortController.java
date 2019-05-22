package com.bangbang.course.controller;

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

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.course.domain.CourseSortDO;
import com.bangbang.course.service.CourseSortService;
import com.bangbang.system.domain.RoleDO;



/**
 * 课程分类列表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
 
@Controller
@RequestMapping("/information/courseSort")
public class CourseSortController {
	@Autowired
	private CourseSortService courseSortService;
	
	@GetMapping()
	@RequiresPermissions("information:courseSort:courseSort")
	String CourseSort(){
	    return "course/courseSort/courseSort";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:courseSort:courseSort")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseSortDO> courseSortList = courseSortService.list(query);
		int total = courseSortService.count(query);
		PageUtils pageUtils = new PageUtils(courseSortList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:courseSort:add")
	String add(){
	    return "course/courseSort/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:courseSort:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CourseSortDO courseSort = courseSortService.get(id);
		model.addAttribute("courseSort", courseSort);
	    return "course/courseSort/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:courseSort:add")
	public R save( CourseSortDO courseSort,String sortName){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sortName", sortName);
		boolean boolName = courseSortService.boolName(map);
		if(boolName){
			return R.error("分类已存在");
		}
		if(courseSortService.save(courseSort)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:courseSort:edit")
	public R update( CourseSortDO courseSort){
		courseSortService.update(courseSort);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:courseSort:remove")
	public R remove( Long id){
		if(courseSortService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:courseSort:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		courseSortService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value="/updateEnable")
	public R updateEnable(Long id,Integer enable) {
		CourseSortDO sysFile = new CourseSortDO();
		sysFile.setId(id);
		sysFile.setStatus(enable);
		courseSortService.updateStatus(sysFile);

		return R.ok();
	}
	
}

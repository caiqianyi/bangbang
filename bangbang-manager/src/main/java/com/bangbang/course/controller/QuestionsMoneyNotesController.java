package com.bangbang.course.controller;

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
import com.bangbang.course.domain.QuestionsMoneyNotesDO;
import com.bangbang.course.service.QuestionsMoneyNotesService;



/**
 * 课程问答金额和说明表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
 
@Controller
@RequestMapping("/information/questionsMoneyNotes")
public class QuestionsMoneyNotesController {
	@Autowired
	private QuestionsMoneyNotesService questionsMoneyNotesService;
	
	@GetMapping()
	@RequiresPermissions("information:questionsMoneyNotes:questionsMoneyNotes")
	String QuestionsMoneyNotes(){
	    return "course/questionsMoneyNotes/questionsMoneyNotes";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:questionsMoneyNotes:questionsMoneyNotes")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QuestionsMoneyNotesDO> questionsMoneyNotesList = questionsMoneyNotesService.list(query);
		int total = questionsMoneyNotesService.count(query);
		PageUtils pageUtils = new PageUtils(questionsMoneyNotesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:questionsMoneyNotes:add")
	String add(){
	    return "course/questionsMoneyNotes/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:questionsMoneyNotes:edit")
	String edit(@PathVariable("id") Long id,Model model){
		QuestionsMoneyNotesDO questionsMoneyNotes = questionsMoneyNotesService.get(id);
		model.addAttribute("questionsMoneyNotes", questionsMoneyNotes);
	    return "course/questionsMoneyNotes/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:questionsMoneyNotes:add")
	public R save( QuestionsMoneyNotesDO questionsMoneyNotes){
		if(questionsMoneyNotesService.save(questionsMoneyNotes)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:questionsMoneyNotes:edit")
	public R update( QuestionsMoneyNotesDO questionsMoneyNotes){
		questionsMoneyNotesService.update(questionsMoneyNotes);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:questionsMoneyNotes:remove")
	public R remove( Long id){
		if(questionsMoneyNotesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:questionsMoneyNotes:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		questionsMoneyNotesService.batchRemove(ids);
		return R.ok();
	}
	
}

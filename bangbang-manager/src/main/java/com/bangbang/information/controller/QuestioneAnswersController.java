package com.bangbang.information.controller;

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
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.service.QuestioneAnswersService;

/**
 * 问答表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 19:00:44
 */
 
@Controller
@RequestMapping("/information/questioneAnswers")
public class QuestioneAnswersController {
	@Autowired
	private QuestioneAnswersService questioneAnswersService;
	
	@GetMapping()
	@RequiresPermissions("information:questioneAnswers:questioneAnswers")
	String QuestioneAnswers(){
	    return "information/questioneAnswers/questioneAnswers";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:questioneAnswers:questioneAnswers")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QuestioneAnswersDO> questioneAnswersList = questioneAnswersService.list(query);
		int total = questioneAnswersService.count(query);
		PageUtils pageUtils = new PageUtils(questioneAnswersList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:questioneAnswers:add")
	String add(){
	    return "information/questioneAnswers/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:questioneAnswers:edit")
	String edit(@PathVariable("id") Long id,Model model){
		QuestioneAnswersDO questioneAnswers = questioneAnswersService.get(id);
		model.addAttribute("questioneAnswers", questioneAnswers);
	    return "information/questioneAnswers/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:questioneAnswers:add")
	public R save( QuestioneAnswersDO questioneAnswers){
		if(questioneAnswersService.save(questioneAnswers)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:questioneAnswers:edit")
	public R update( QuestioneAnswersDO questioneAnswers){
		questioneAnswersService.update(questioneAnswers);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:questioneAnswers:remove")
	public R remove( Long id){
		if(questioneAnswersService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:questioneAnswers:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		questioneAnswersService.batchRemove(ids);
		return R.ok();
	}
	
}

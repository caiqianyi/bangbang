package com.bangbang.information.controller;

import java.util.ArrayList;
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
import com.bangbang.common.controller.BaseController;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.domain.QuestioneAnswersImageDO;
import com.bangbang.information.domain.QuestionsMoneyNotesDO;
import com.bangbang.information.service.QuestioneAnswersImageService;
import com.bangbang.information.service.QuestioneAnswersService;
import com.bangbang.information.service.QuestionsMoneyNotesService;
import com.bangbang.teacher.domain.TeacherDO;
import com.bangbang.teacher.service.TeacherService;

/**
 * 问答表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 19:00:44
 */
 
@Controller
@RequestMapping("/bangbang/questioneAnswers")
public class QuestioneAnswersController extends BaseController{
	@Autowired
	private QuestioneAnswersService questioneAnswersService;
	@Autowired
	private QuestionsMoneyNotesService questionsMoneyNotesService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private QuestioneAnswersImageService questioneAnswersImageService;
	@Autowired
	private TeacherService teacherService;
	
	/*
	 * 付费问答
	 */
	@ResponseBody
	@GetMapping("/quentList")
	Map<String, Object> quentList(Long courseId){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapT = new HashMap<String, Object>();
		QuestionsMoneyNotesDO quentList = questionsMoneyNotesService.get(courseId);
		String questionsTeacher = quentList.getQuestionsTeacher();
		String[] split = questionsTeacher.split(",");
		for (String string : split) {
			Map<String, Object> mapP = new HashMap<String, Object>();
			TeacherDO headUrl = teacherService.getHeadUrl(string);
			String url = headUrl.getHeadUrl();
			mapP.put(string, url);
			mapT.putAll(mapP);
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("teacherHead", mapT);
		map.put("data", quentList);
		return map;
	}
		
	/*
	 * 提交付费问答
	 */
	@ResponseBody
	@PostMapping("/quentNote")
	Map<String, Object> quentNote(QuestioneAnswersDO questioneAnswers,Long courseId,Long userId){
		Map<String, Object> map = new HashMap<String, Object>();
		QuestioneAnswersDO questioneA = new QuestioneAnswersDO();
		questioneA.setUserId(userId);
		questioneA.setQuestionsMoney(questioneAnswers.getQuestionsMoney()); 
		String teacher = questioneAnswers.getQuestionsTeacher();
		questioneA.setQuestionsTeacher(teacher); 
		TeacherDO tId = teacherService.getHeadUrl(teacher);
		questioneA.setTeacherId(tId.getId());
		questioneA.setCourseId(courseId);
		if(questioneAnswers.getQuestionsContent() != null){
			questioneA.setQuestionsContent(questioneAnswers.getQuestionsContent());
		}
		questioneA.setAddTime(new Date());
		questioneA.setIfreply(1);
		MultipartFile[] files = questioneAnswers.getAskimgs();
		int save = questioneAnswersService.save(questioneA);
		if(files != null && files.length > 0){
			try {
				for (MultipartFile file : files) {
					String fileName = file.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);	
					FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
					QuestioneAnswersImageDO img = new QuestioneAnswersImageDO();
					img.setPicImg("/files/" +fileName);
					img.setQuestionAnswersId(questioneA.getId());
					img.setStatus(0);
					questioneAnswersImageService.save(img);
					
				}
				
			} catch (Exception e) {
				return R.error();
			}
			
		}
		if(save>0){
			map.put("code", 0);
			map.put("msg", "保存成功");
		}else{
			map.put("code", 1);
			map.put("msg", "保存失败");
		}
		return map;
		
	}

	
}

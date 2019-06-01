package com.bangbang.teacher.controller;

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
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.domain.QuestioneAnswersImageDO;
import com.bangbang.information.service.QuestioneAnswersImageService;
import com.bangbang.information.service.QuestioneAnswersService;
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
	private QuestioneAnswersService questioneAnswersService;
	@Autowired
	private QuestioneAnswersImageService questioneAnswersImageService;
	
	/*
	 * 提问详情
	 */
	@ResponseBody
	@GetMapping("/quentInfo")
	Map<String, Object> quentInfo(Long teacherId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String, Object>> teacherQA = teacherService.getTeacherQA(teacherId);
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", teacherQA);
		return map;
		
	}
	
	/*
	 * 回复提问
	 */
	@ResponseBody
	@PostMapping("/quentReply")
	Map<String, Object> quentReply(QuestioneAnswersDO questioneAnswers,Long id){
		Map<String,Object> map = new HashMap<String,Object>();
		QuestioneAnswersDO AnswersDO = questioneAnswersService.get(id);
		if(questioneAnswers.getReplyContent() != null){
			AnswersDO.setReplyContent(questioneAnswers.getReplyContent());
		}
		AnswersDO.setIfreply(0);
		AnswersDO.setReplyTime(new Date());
		MultipartFile[] files = questioneAnswers.getAskimgs();
		if(files != null && files.length > 0){
			try {
				for (MultipartFile file : files) {
					String fileName = file.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);	
					FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
					QuestioneAnswersImageDO img = new QuestioneAnswersImageDO();
					img.setPicImg("/files/" +fileName);
					img.setQuestionAnswersId(AnswersDO.getId());
					img.setStatus(1);
					questioneAnswersImageService.save(img);
					
				}
				
			} catch (Exception e) {
				return R.error();
			}
			
		}
		if(questioneAnswersService.update(AnswersDO)>0){
			map.put("code", 0);
			map.put("msg", "回复成功");
		}else{
			map.put("code", 1);
			map.put("msg", "回复失败");
		}
		
		return map;
		
	}
	
	
}

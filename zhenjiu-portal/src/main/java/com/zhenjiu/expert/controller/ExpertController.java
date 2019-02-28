package com.zhenjiu.expert.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenjiu.expert.domain.ExpertDO;
import com.zhenjiu.expert.service.ExpertService;
import com.zhenjiu.news.domain.NewsDO;
import com.zhenjiu.news.service.NewsService;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-15 09:53:23
 */
 
@RestController
@RequestMapping("/zhenjiu/expert")
public class ExpertController {
	@Autowired
	private ExpertService expertService;
	@Autowired
	private NewsService newServidce;
	/**
	 * 专家列表接口
	 */
	@GetMapping("/list")
	Map<String,Object> Expert(){
		 Map<String, Object> map = new HashMap<>();
	        List<ExpertDO> list = expertService.list(new HashMap<String,Object>());
	        map.put("data", list);
	        return map;
	}
	
	/**
	 * 专家详情信息接口
	 */
	@PostMapping("/info")
	Map<String,Object> info(long id){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("uId", id);
		List<NewsDO> list = newServidce.list(params);
		for(int i=0;i<list.size();i++){
			NewsDO no = list.get(i);
			no.setContent(getSubString(no.getContent(), 10));//文章内容截取
		}
		Map<String,Object> map = new HashMap<String,Object>();
		ExpertDO expertDO= expertService.get(id);
		map.put("data", expertDO);
		map.put("article",list);
		return map;
	}
	
	/**
	 * 文章内容接口 
	 */
	@PostMapping("/article")
	Map<String,Object> article(long id){
		Map<String,Object> map = new HashMap<String,Object>();
		NewsDO newsDO = newServidce.get(id);
		map.put("data", newsDO);
		return map;
	}
	
	public String getSubString(String str,int length){
		if(str==null)
			str="";
		else{
			int size = str.length();
			if(size>=length){
			    char[] c = str.toCharArray();
				str = String.valueOf(Arrays.copyOf(c, length));
			}
		}
		return str;	
	}
}

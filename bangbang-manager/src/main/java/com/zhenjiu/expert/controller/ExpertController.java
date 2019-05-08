package com.zhenjiu.expert.controller;

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


import com.zhenjiu.common.config.BootdoConfig;
import com.zhenjiu.common.utils.FileUtil;
import com.zhenjiu.common.utils.PageUtils;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.common.utils.ShiroUtils;
import com.zhenjiu.expert.domain.ExpertDO;
import com.zhenjiu.expert.service.ExpertService;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-15 09:53:23
 */
 
@Controller
@RequestMapping("/information/expert")
public class ExpertController {
	@Autowired
	private ExpertService expertService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@GetMapping()
	@RequiresPermissions("information:expert:expert")
	String Expert(Model model){
		List<ExpertDO> list = expertService.list(new HashMap<String,Object>());
		model.addAttribute("list",list);
	    return "information/expert/expert";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:expert:expert")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        query.put("diagnoseDepartment", params.get("diagnoseDepartment"));
		List<ExpertDO> expertList = expertService.list(query);
		int total = expertService.count(query);
		PageUtils pageUtils = new PageUtils(expertList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:expert:add")
	String add(){
	    return "information/expert/add";
	}

	@GetMapping("/edit/{id}/{bb}")
	@RequiresPermissions("information:expert:edit")
	String edit(@PathVariable("id") Long id,@PathVariable("bb") Integer bb, Model model){
		ExpertDO expert = expertService.get(id);
		model.addAttribute("expert", expert);
		if(bb==0)
			return "information/expert/edit";
		return "information/expert/xiangqing";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:expert:add")
	public R save( ExpertDO expert){
		try {
			if(expert.getTouxiang() != null && expert.getTouxiang().getSize() > 0){
				String fileName = expert.getTouxiang().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(expert.getTouxiang().getBytes(), bootdoConfig.getUploadPath()+"expert/", fileName);
				expert.setHeadshot("/files/expert/" + fileName);
			}
			expert.setIsLogin(0);
			expert.setDeleted(0);
			
			expert.setAddTime(new Date());
			expert.setUpdateTime(new Date());
		} catch (Exception e) {
			return R.error();
		}
		if(expertService.save(expert)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:expert:edit")
	public R update( ExpertDO expert){
		if(expert.getTouxiang() != null && expert.getTouxiang().getSize() > 0){
			String fileName = expert.getTouxiang().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(expert.getTouxiang().getBytes(), bootdoConfig.getUploadPath()+"expert/", fileName);
				expert.setHeadshot("/files/expert/" + fileName);
				expert.setUpdateTime(new Date());
			} catch (Exception e) {
				return R.error();
			}
			
		}
		expertService.update(expert);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:expert:remove")
	public R remove( Long id){
		ExpertDO expertDO = new ExpertDO();
		expertDO.setId(id);
		expertDO.setDeleted(1);
		if(expertService.update(expertDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:expert:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		expertService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 更新状态
	 */
	@PostMapping( "/updateEnable")
	@ResponseBody
	@RequiresPermissions("information:expert:remove")
	public R updateEnable( Long id,Integer enable){
		ExpertDO expertDO = new ExpertDO();
		expertDO.setId(id);
		expertDO.setIsLogin(enable);
		if(expertService.update(expertDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
}

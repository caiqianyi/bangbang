package com.bangbang.medal.controller;

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
import com.bangbang.medal.domain.MedalDO;
import com.bangbang.medal.service.MedalService;
import com.bangbang.owneruser.comment.GenerateCode;


/**
 * 勋章表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 10:26:16
 */
 
@Controller
@RequestMapping("/information/medal")
public class MedalController {
	@Autowired
	private MedalService medalService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	
	@GetMapping()
	@RequiresPermissions("information:medal:medal")
	String Medal(){
	    return "medal/medal";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:medal:medal")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MedalDO> medalList = medalService.list(query);
		int total = medalService.count(query);
		PageUtils pageUtils = new PageUtils(medalList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:medal:add")
	String add(){
	    return "medal/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:medal:edit")
	String edit(@PathVariable("id") Long id,Model model){
		MedalDO medal = medalService.get(id);
		model.addAttribute("medal", medal);
	    return "medal/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:medal:add")
	public R save( MedalDO medal){
		Long MedalId = GenerateCode.gen16(6);
		medal.setMedalId(MedalId);
		
		MultipartFile imgFile = medal.getImgFile();
		String fileName = imgFile.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);		
		try {	
			OssUtils ossUtils=new OssUtils(fileName);
	        String headurl =  ossUtils.uploadObject(imgFile);
			//FileUtil.uploadFile(medal.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
			medal.setMedalIco(headurl);
			medal.setAddTime(new Date());
		} catch (Exception e) {
			return R.error();
		}
		if(medalService.save(medal)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:medal:edit")
	public R update( MedalDO medal){
		if(medal.getImgFile() != null && medal.getImgFile().getSize() > 0){
			MultipartFile imgFile = medal.getImgFile();
			String fileName = imgFile.getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				OssUtils ossUtils=new OssUtils(fileName);
		        String headurl =  ossUtils.uploadObject(imgFile);
				//FileUtil.uploadFile(medal.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				medal.setMedalIco(headurl);
			} catch (Exception e) {
				return R.error();
			}
		}
		medalService.update(medal);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:medal:remove")
	public R remove( Long id){
		if(medalService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:medal:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		medalService.batchRemove(ids);
		return R.ok();
	}
	
}

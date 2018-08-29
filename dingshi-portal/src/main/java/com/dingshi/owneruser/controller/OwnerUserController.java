package com.dingshi.owneruser.controller;

import com.dingshi.common.annotation.Log;
import com.dingshi.common.config.BootdoConfig;
import com.dingshi.common.config.Constant;
import com.dingshi.common.controller.BaseController;
import com.dingshi.common.utils.*;
import com.dingshi.information.domain.FilesDO;
import com.dingshi.owneruser.domain.OwnerUserDO;
import com.dingshi.owneruser.domain.UserPlotDO;
import com.dingshi.owneruser.service.OwnerUserService;
import com.dingshi.owneruser.service.UserPlotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/owner")
@Controller
public class OwnerUserController extends BaseController {
	private String prefix="user"  ;
	@Autowired
	OwnerUserService userService;
	@Autowired
	UserPlotService plotService;
	@Autowired
	private BootdoConfig bootdoConfig;
	/**
	 * 个人中心
	 * @return
	 */
	@GetMapping("/user")
	String user(Model model) {
		OwnerUserDO udo= userService.get(getUserId());
		model.addAttribute("user", udo);
		return prefix + "/gerenzhongxin";
	}
	/**
	 * 获取用户信息
	 * @return
	 */
	@GetMapping("/userInfo")
	String userInfo(Model model) {
		OwnerUserDO udo=userService.get(getUserId());
		model.addAttribute("user", udo);
		return prefix + "/gerenxinxi";
	}
	/**
	 * 编辑用户信息
	 * @return
	 */
	@Log("更新用户")
	@PostMapping("/editInfo")
	@ResponseBody
	R editInfo(OwnerUserDO user) {
		OwnerUserDO userd = userService.getbyname(user.getUsername());
		if(user.getHeardUrl()!=null){
			userd.setHeardUrl(user.getHeardUrl());
		}
		if(user.getNickname()!=null){
			userd.setNickname(user.getNickname());
		}
		if(user.getName()!=null){
			userd.setName(user.getName());
		}
		if(user.getIdentityCard()!=null){
			userd.setIdentityCard(user.getIdentityCard());
		}
		if(user.getFileImg() != null && user.getFileImg().getSize() > 0){
				MultipartFile sysFile = user.getFileImg();
				String fileName = sysFile.getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				try {
					FileUtil.uploadFile(sysFile.getBytes(), bootdoConfig.getUploadPath(), fileName);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				userd.setHeardUrl("/files/" + fileName);
		}
		if (userService.update(userd) > 0) {
			
			return R.ok();
		}
		return R.error();
	}
	

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value="/updateEnable")
	public R updateEnable(Long id,Integer enable) {
		OwnerUserDO oudo = userService.get(id);
		oudo.setId(id);
		oudo.setDeleteFlag(enable);
		userService.update(oudo);

		return R.ok();
	}

}

package com.zhenjiu.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenjiu.common.controller.BaseController;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.information.domain.ComplaintDO;
import com.zhenjiu.information.service.ComplaintService;
import com.zhenjiu.owneruser.domain.OwnerUserDO;
import com.zhenjiu.owneruser.domain.UserPlotDO;
import com.zhenjiu.owneruser.service.OwnerUserService;
import com.zhenjiu.owneruser.service.UserPlotService;

/**
 * 用户发帖表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-04-13 14:32:12
 */
 
@Controller
@RequestMapping("/information/complaint")
public class ComplaintController extends BaseController{
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	UserPlotService plotService;
	@Autowired
	OwnerUserService userService;
	
	
	@GetMapping()
	String Complaint(Model model){
		List<UserPlotDO> pdoL= plotService.listbyid(getUserId());
		model.addAttribute("pdoL", pdoL);
		OwnerUserDO udo= userService.get(getUserId());
		model.addAttribute("user", udo);
		return "information/complaint/zaixiantousu";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( ComplaintDO complaint){
		complaint.setUserId(this.getUserId().intValue());
		if(complaintService.save(complaint)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 获取小区负责人ID
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getPlotPhone")
	public R getPlotPhone(Long id){
		String phone = this.complaintService.getPlotPhone(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", phone);
		return R.ok(map);
	}
}

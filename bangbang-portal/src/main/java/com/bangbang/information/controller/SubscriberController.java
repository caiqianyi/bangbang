package com.bangbang.information.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Multipart;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.internal.OSSUtils;
import com.bangbang.common.annotation.Log;
import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.OssUtils;
import com.bangbang.information.domain.LeaveMessageDO;
import com.bangbang.information.domain.QuestioneAnswersDO;
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubscriberService;

@RestController
@RequestMapping("/bangbang/subscriber")
public class SubscriberController {
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private SubscriberService subscriberService;
	
	/**
	 * 查询用户的信息
	 */
	@Log("用户信息查询接口")
	@GetMapping("/info")
	public Map<String,Object> getSubscriberInfo(String phone){
		SubscriberDO subscriberDO = subscriberService.getInfo(phone);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","");
		map.put("data", subscriberDO);
		return map;
	}
	
	/**
	 * 更改昵称
	 */
	@Log("更改昵称")
	@PostMapping("/updateNickname")
	public Map<String,Object> updateNickname(Long id,String nickname){
		int result=subscriberService.updateNickname(id,nickname);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0){
			map.put("code", 0);
			map.put("msg","昵称修改成功");
		}
		else{
			map.put("code", 1);
			map.put("msg","昵称修改失败");
		}
		return map;
	}
	
	/**
	 * 更改手机号
	 */
	@Log("更改手机号")
	@PostMapping("/updatePhone")
	public Map<String,Object> updatePhone(Long id,String phone){
		int result=subscriberService.updatePhone(id,phone);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0){
			map.put("code", 0);
			map.put("msg","手机号修改成功");
		}
			
		else{
			map.put("code", 1);
			map.put("msg","手机号修改失败");
		}
		return map;
	}
	
	/**
	 * 更改用户签名
	 */
	@Log("更改用户签名")
	@PostMapping("/updateSignName")
	public Map<String,Object> updateSignName(Long id,String signName){
		int result=subscriberService.updateSignName(id,signName);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0){
			map.put("code", 0);
			map.put("msg","签名修改成功");
		}
			
		else{
			map.put("code", 1);
			map.put("msg","签名修改失败");
		}
			
		return map;
	}
	
	/**
	 * 更改出生年月
	 */
	@Log("更改出生年月接口")
	@PostMapping("/updateBirthday")
	public Map<String,Object> updateBirthday(Long id,Date birthday){
		int result=subscriberService.updateBirthday(id,birthday);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0){
			map.put("code", 0);
			map.put("msg","修改成功");
		}	
		else{
			map.put("code", 1);
			map.put("msg","修改失败");
		}
		return map;
	}
	
	/**
	 * 更改性别
	 */
	@Log("修改性别接口")
	@PostMapping("/updateSex")
	public Map<String,Object> updateSex(Long id,Integer sex){
		int result=subscriberService.updateSex(id,sex);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0){
			map.put("code", 0);
			map.put("msg","修改成功");
		}
			
		else{
			map.put("code", 1);
			map.put("msg","修改失败");
		}
		return map;
	}
	
	/**
	 * 修改用户头像
	 */
	@Log("修改用户头像")
	@PostMapping("/updateHeadSculpture")
	public Map<String,Object> updateHeadSculpture(SubscriberDO subscriberDO,MultipartFile file){
		  Map<String, Object> map = new HashMap<>();
	    
	        if (file != null && file.getSize() > 0) {
	        	String fileName=file.getOriginalFilename();
	        	fileName = FileUtil.renameToUUID(fileName);
				OssUtils ossUtils=new OssUtils(fileName);
		        String headurl =  ossUtils.uploadObject(file);
	        
	            if (subscriberService.updateHeadUrl(subscriberDO.getId(),headurl)>0) {
	            	map.put("code", 0);
	                map.put("msg", "头像保存成功");
	                map.put("data", headurl);
	            } else {
	            	map.put("code", 1);
	                map.put("msg", "头像保存失败");
	                map.put("data","");
	            }
	        }else{
	        	map.put("code", 1);
	            map.put("msg", "头像附件为空");
	        }
	        return map;
	}
}

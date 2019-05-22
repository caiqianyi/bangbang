package com.bangbang.information.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.common.utils.ShiroUtils;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseService;
import com.bangbang.information.domain.ReedeemDO;
import com.bangbang.information.domain.SendoutReedeemDO;
import com.bangbang.information.service.ReedeemService;
import com.bangbang.information.service.SendoutReedeemService;



/**
 * 兑换码表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-14 13:35:00
 */
 
@Controller
@RequestMapping("/information/reedeem")
public class ReedeemController {
	@Autowired
	private ReedeemService reedeemService;
	@Autowired
	private CourseService courseServcie;
	@Autowired
	private SendoutReedeemService sendoutReedeemService;
	@GetMapping()
	@RequiresPermissions("information:reedeem:reedeem")
	String Reedeem(){
	    return "information/reedeem/reedeem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:reedeem:reedeem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReedeemDO> reedeemList = reedeemService.list(query);
		int total = reedeemService.count(query);
		PageUtils pageUtils = new PageUtils(reedeemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:reedeem:add")
	String add(Model model){
		List<CourseDO> courseDOs=courseServcie.list(new HashMap<String,Object>());
		model.addAttribute("courseDOs", courseDOs);
	    return "information/reedeem/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:reedeem:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ReedeemDO reedeem = reedeemService.get(id);
		model.addAttribute("reedeem", reedeem);
		List<CourseDO> courseDOs=courseServcie.list(new HashMap<String,Object>());
		model.addAttribute("courseDOs", courseDOs);
	    return "information/reedeem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:reedeem:add")
	public R save( ReedeemDO reedeem){
		int i=0;
		String code="";
		Map<String,Object> map = new HashMap<String,Object>();
		while(i++<5){
			code = createBigStrOrNumberRadom(8);
			map.put("reedeemCode",code);
			List<ReedeemDO> list = reedeemService.list(map);
			if(list.size()>0)
				code = createBigStrOrNumberRadom(8);
			else
				break;
		}
		if(i==5)
			return R.error("兑换码创建失败！！");
		reedeem.setIfStop(0);
		reedeem.setCreateTime(new Date());
		reedeem.setReedeemSurplus(reedeem.getReedeemCount());
		reedeem.setReedeemCode(code);
		reedeem.setCreateId(ShiroUtils.getUserId());
		reedeem.setCreateName(ShiroUtils.getUser().getName());
		reedeem.setDeleteFlag(0);
		
		reedeem.setReedeemCode(createBigStrOrNumberRadom(8));
		if(reedeemService.save(reedeem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:reedeem:edit")
	public R update( ReedeemDO reedeem){
		reedeemService.update(reedeem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:reedeem:remove")
	public R remove( Long id){
		if(reedeemService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:reedeem:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		reedeemService.batchRemove(ids);
		return R.ok();
	}
	
	 /**
    *
    * @function 生成num位的随机字符串(数字、大写字母随机混排)
    * @param num
    * @return
    */
   public static String createBigSmallLetterStrOrNumberRadom(int num) {

       String str = "";
       for(int i=0;i < num;i++){
           int intVal=(int)(Math.random()*58+65);
           if(intVal >= 91 && intVal <= 96){
               i--;
           }
           if(intVal < 91 || intVal > 96){
               if(intVal%2==0){
                   str += (char)intVal;
               }else{
                   str += (int)(Math.random()*10);
               }
           }
       }
       return str;
   }
   /**
    *
    * @function 生成num位的随机字符串(数字、小写字母随机混排)
    * @param num
    * @return
    */
   public static String createSmallStrOrNumberRadom(int num) {

       String str = "";
       for(int i=0;i < num;i++){
           int intVal=(int)(Math.random()*26+97);
           if(intVal%2==0){
               str += (char)intVal;
           }else{
               str += (int)(Math.random()*10);
           }
       }
       return str;
   }
   /**
    *
    * @function 生成num位的随机字符串(小写字母与数字混排)
    * @param num
    * @return
    */
   public static String createBigStrOrNumberRadom(int num) {

       String str = "";
       for(int i=0;i < num;i++){
           int intVal=(int)(Math.random()*26+65);
           if(intVal%2==0){
               str += (char)intVal;
           }else{
               str += (int)(Math.random()*10);
           }
       }
       return str;
   }

   
  /* @ResponseBody
   @PostMapping("/checkIfStop")
   public List<SendoutReedeemDO> checkIfStop(String reedeemCode){
	   Map<String,Object> map = new HashMap<String,Object>();
	   map.put("reedeemCode", reedeemCode);
	   return sendoutReedeemService.list(map);
   }*/

    @PostMapping( "/updateIfStop")
	@ResponseBody
	public R  updateIfStop( Long id,Integer enable){
		ReedeemDO reedeemDO = new ReedeemDO();
		reedeemDO.setIfStop(enable);
		reedeemDO.setId(id);
		reedeemService.update(reedeemDO);
		return R.ok();
		
	}
}

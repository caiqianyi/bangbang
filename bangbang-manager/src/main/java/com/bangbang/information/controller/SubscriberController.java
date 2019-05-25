package com.bangbang.information.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangbang.common.utils.ExcelExportUtil4DIY;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.common.utils.ShiroUtils;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubscriberService;



/**
 * 用户信息表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 10:03:50
 */
 
@Controller
@RequestMapping("/information/subscriber")
public class SubscriberController {
	@Autowired
	private SubscriberService userService;
	
	private static Logger logger = LoggerFactory.getLogger(SubscriberController.class);
	
	@GetMapping()
	@RequiresPermissions("information:subscriber:subscriber")
	String User(){
	    return "information/subscriber/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:subscriber:subscriber")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubscriberDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:subscriber:add")
	String add(){
	    return "information/subscriber/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:subscriber:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SubscriberDO user = userService.get(id);
		model.addAttribute("user", user);
	    return "information/subscriber/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:subscriber:add")
	public R save( SubscriberDO user){
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 导出
	 * */
	@RequestMapping(value="/exportExcel")
	public void exportExcel(@RequestParam Map<String, Object> params,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "帮邦用户列表"+format.format(new Date().getTime())+".xls";
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
		OutputStream out = response.getOutputStream();
		System.out.println("==============================="+params);
	try {
		Query query = new Query(params);
		String type = request.getParameter("type");
		
		//导出全部数据
		if(type.equals("2")){
			List<Map<String, Object>> XxxDOs = userService.exeList(params);
			if( XxxDOs == null){
				R.error("当前数据为空");
			}
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
		
		//导选中部分
		if(type.equals("4")){
			query.remove("offset");
			query.remove("limit");
			System.out.println("========================================ids:"+query.get("ids"));
			List<Map<String, Object>> XxxDOs = userService.exeList(query);
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
	} catch (Exception e) {
		e.printStackTrace();
		logger.info("exportExcel出错"+e.getMessage());
		}finally{
			out.close();
		}
	}
	
	
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:subscriber:edit")
	public R update( SubscriberDO user){
		userService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:subscriber:remove")
	public R remove( Long id){
		if(userService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:subscriber:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		userService.batchRemove(ids);
		return R.ok();
	}
	
}

package com.zhenjiu.information.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenjiu.common.utils.ExcelExportUtil4DIY;
import com.zhenjiu.common.utils.PageUtils;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.common.utils.R;
import com.zhenjiu.information.domain.DataDO;
import com.zhenjiu.information.service.DataStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/information/dataStatis")
public class DataStatisticsController {
	private static Logger logger = LoggerFactory.getLogger(DataStatisticsController.class);
	
	@Autowired
	private DataStatisticsService dataStatisticsService;
	
	@GetMapping()
	@RequiresPermissions("information:dataStatis:dataStatis")
	String Data(){
	    return "information/datastat/data";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:dataStatis:dataStatis")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<DataDO> dataList = dataStatisticsService.list(query);
		System.out.println(dataList);
		int total = dataStatisticsService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/selectByUsername")
	@RequiresPermissions("information:dataStatis:dataStatis")
	public PageUtils selectByUsername(@RequestParam Map<String, Object> params,String name){
		//查询列表数据
		Query query = new Query(params);
		List<DataDO> dataList = dataStatisticsService.selectByUsername(name);
		int total = dataStatisticsService.count(query);
		PageUtils pageUtils = new PageUtils(dataList, total);
		return pageUtils;
	}
	
	
	@GetMapping("/add")
	@RequiresPermissions("information:dataStatis:add")
	String add(){
	    return "information/datastat/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:dataStatis:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DataDO data = dataStatisticsService.get(id);
		model.addAttribute("data", data);
	    return "information/datastat/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:dataStatis:add")
	public R save( DataDO data){
		if(dataStatisticsService.save(data)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:dataStatis:edit")
	public R update( DataDO data){
		dataStatisticsService.update(data);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:dataStatis:remove")
	public R remove( Integer id){
		if(dataStatisticsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:dataStatis:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		dataStatisticsService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 导出
	 * */
	@RequestMapping(value="/exportExcel")
	public void exportExcel(@RequestParam Map<String, Object> params,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "针灸数据统计表"+format.format(new Date().getTime())+".xls";
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
		OutputStream out = response.getOutputStream();
	try {
		Query query = new Query(params);
		String type = request.getParameter("type");
		//导出当前页面数据
		if(type.equals("1")){
			List<Map<String, Object>> XxxDOs = dataStatisticsService.exeList(query);
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
		//导出全部数据
		if(type.equals("2")){
			List<Map<String, Object>> XxxDOs = dataStatisticsService.exeList(null);
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
		//导出符合条件的全部数据
		if(type.equals("3")){
			query.remove("offset");
			query.remove("limit");
			List<Map<String, Object>> XxxDOs = dataStatisticsService.exeList(query);
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
		//导选中部分
		if(type.equals("4")){
			query.remove("offset");
			query.remove("limit");
			System.out.println("ids:"+query.get("ids"));
			List<Map<String, Object>> XxxDOs = dataStatisticsService.exeList(query);
		     System.out.println("===s===zhil====="+XxxDOs.get(0).get("治疗时长"));
			ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
		}
	} catch (Exception e) {
		e.printStackTrace();
		logger.info("exportExcel出错"+e.getMessage());
		}finally{
			out.close();
		}
	}
	
	
	
}

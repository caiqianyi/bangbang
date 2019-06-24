package com.bangbang.course.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;

import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.OssUtils;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;
import com.bangbang.course.domain.CourseChapterDO;
import com.bangbang.course.domain.CourseDO;
import com.bangbang.course.service.CourseChapterService;
import com.bangbang.course.service.CourseService;

import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;





/**
 * 课程章节
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-11 11:53:20
 */
 
@Controller
@RequestMapping("/information/courseChapter")
public class CourseChapterController {
	@Autowired
	private CourseChapterService courseChapterService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("information:courseChapter:courseChapter")
	String CourseChapter(){
	    return "course/courseChapter/courseChapter";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:courseChapter:courseChapter")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseChapterDO> courseChapterList = courseChapterService.list(query);
		int total = courseChapterService.count(query);
		PageUtils pageUtils = new PageUtils(courseChapterList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{id}")
	@RequiresPermissions("information:courseChapter:add")
	String add(@PathVariable("id")Long id,Model model){
		CourseDO course = courseService.get(id);
		model.addAttribute("course", course);
	    return "course/courseChapter/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:courseChapter:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CourseChapterDO courseChapter = courseChapterService.get(id);
		model.addAttribute("courseChapter", courseChapter);
	    return "course/courseChapter/edit";
	}
	
	@GetMapping("/cha/{id}")
	@RequiresPermissions("information:courseChapter:edit")
	String cha(@PathVariable("id") Long id,Model model){
		CourseChapterDO courseChapter = courseChapterService.get(id);
		model.addAttribute("courseChapter", courseChapter);
	    return "course/courseChapter/cha";
	}
	
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:courseChapter:add")
	public R save( CourseChapterDO courseChapter,HttpServletRequest request,HttpServletResponse response)throws IOException{
		MultipartFile imgFile = courseChapter.getImgFile();
		String fileName = imgFile.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);	
		File f = null;
		String time = "";
		try {			
			//OssUtils ossUtils=new OssUtils(fileName);
			String url = OssUtils.uploadObject2OSS2(OssUtils.BUCKET_NAME,imgFile,fileName,request);
			try {
				f = File.createTempFile("tmp", null);
				imgFile.transferTo(f);
				MultimediaObject instance = new MultimediaObject(f);
			    MultimediaInfo result = instance.getInfo();
			    long l = result.getDuration();
			    if(l / 60000 != 0){
			    	time = l / 60000 +":"+ (l % 60000) / 1000;
			    }else{
			    	time = "00:"+ (l % 60000) / 1000;
			    }
			    //System.out.println(time);
				f.delete();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			courseChapter.setDuration(time);
			courseChapter.setUrl(url);
		} catch (Exception e) {
			return R.error();
		}
		courseChapter.setAddTime(new Date());
		
		if(courseChapterService.save(courseChapter)>0){
			Map<String, Object> params = new HashMap<String, Object>();
			Long courseId = courseChapter.getCourseId();
			int courseNum = courseChapterService.queryCourse(courseId);
			params.put("courseId", courseId);
			List<CourseDO> list = courseService.list(params);
			Long id = list.get(0).getId();
			CourseDO course = courseService.get(id);
			course.setChapterNum(courseNum);
			courseService.update(course);
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 上传进度
	 */
	@ResponseBody
	@PostMapping("/percent")
	public Map<String, Integer> getUploadPercent(HttpServletRequest request){
		Map<String, Integer> map = new HashMap<String, Integer>();
		HttpSession session = request.getSession();
		int percent = session.getAttribute("upload_percent") == null ? 0 : (Integer)session.getAttribute("upload_percent");
        int end = session.getAttribute("upload_end") == null ? 0: (Integer)session.getAttribute("upload_end");
        map.put("percent", percent);
        map.put("end", end);
        return map;
		
	}
	
	/**
	 * 重置进度
	 */
	@ResponseBody
	@PostMapping("/percent/reset")
	public void clearUploadPercent(HttpServletRequest request) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.setAttribute("upload_percent",0);		
		
	}	
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:courseChapter:edit")
	public R update( CourseChapterDO courseChapter){
		courseChapterService.update(courseChapter);
		return R.ok();
	}


	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:courseChapter:remove")
	public R remove( Long id){
		
		CourseChapterDO courseChapter = courseChapterService.get(id);
		Long courseId = courseChapter.getCourseId();
		if(courseChapterService.remove(id)>0){
			int courseNum = courseChapterService.queryCourse(courseId);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("courseId", courseId);
			List<CourseDO> list = courseService.list(params);
			Long ids = list.get(0).getId();
			CourseDO course = courseService.get(ids);
			course.setChapterNum(courseNum);
			courseService.update(course);
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:courseChapter:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		courseChapterService.batchRemove(ids);
		return R.ok();
	}
	
}

package com.bangbang.information.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bangbang.common.annotation.Log;
import com.bangbang.information.domain.CourseChapterDO;
import com.bangbang.information.domain.CourseDO;
import com.bangbang.information.domain.CourseSortDO;
import com.bangbang.information.domain.PlayRecordDO;
import com.bangbang.information.domain.SubcriberLogDO;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.CourseServcie;
import com.bangbang.information.service.SubscriberService;

@RestController
@RequestMapping("/bangbang/course")
public class CourseController {

	@Autowired
	private CourseServcie courseService;
	@Autowired
	private SubscriberService subscriberService;
	/**
	 * 查询课程分类接口
	 */
	@Log("查询课程分类接口")
	@GetMapping("/getAllCourseSort")
	public Map<String,Object> getAllCourseDort(){
		List<CourseSortDO> list = courseService.getAllCourseSort();
		Map<String,Object> map = new HashMap<String,Object>();
		if(list.size()>0){
			map.put("code", 0);
			map.put("msg", "success");
			map.put("data",list);
		}
		else{
			map.put("code", 1);
			map.put("msg", "暂无课程分类");
			map.put("data",list);
		}
		
		return map;
	}
	
	/**
	 * 根据分类查询下属的所有课程
	 */
	@Log("查询分类下属的课程接口")
	@GetMapping("/getAllCourseBySortId")
	public Map<String,Object> getAllCourseBySortId(Long id,Long userId){
		Map<String,Object> map=new HashMap<String,Object>();
		List<CourseDO> list = courseService.getAllCourseBySortId(id);
		if(list.size()==0){
			map.put("code", 1);
			map.put("msg","该分类下，暂无课程");
			map.put("data",list);
		}
		else{
			for(CourseDO courseDO :list){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("courseId", courseDO.getCourseId());
				params.put("userId", userId);
				params.put("flag", 0);
				List<SubcriberLogDO> list1 = courseService.getAllCourseByFlag(params);
				if(list1.size()==0) courseDO.setIfNBuy(1);//未购买
				else courseDO.setIfNBuy(0);//已购买
			
				params.remove("userId");params.remove("flag");
				int count = courseService.getPlayRecord(params).size();
				courseDO.setPlayTimes(count);
			}
			map.put("code", 0);
			map.put("msg","");
			map.put("data",list);
		}
		
		return map;
	}
	
	/**
	 * 查询购买的课程章节
	 */
	@Log("查询的章节接口")
	@GetMapping("/getAllCharacterByCourseId")
	public Map<String,Object> getAllCharacterByCourseId(Long courseId,Long userId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<CourseChapterDO> list = courseService.getCourseCharacterByCourseId(courseId);
		
		if(list.size()==0){
			resultMap.put("code", 1);
			resultMap.put("msg","课程章节缺失...");
			resultMap.put("data","");
		}
		else{
			PlayRecordDO playRecordDO=courseService.getPlayRecordByUserIdAndCourseId(courseId,userId);
			if(playRecordDO==null)
				playRecordDO=new PlayRecordDO();
			map.put("list",list);
			map.put("chapterName",playRecordDO.getChapterName());
			map.put("characterId",playRecordDO.getCharacterId());
			resultMap.put("code", 0);
			resultMap.put("msg", "");
			resultMap.put("data", map);
		}
		return resultMap;
	}
	
	/**
	 * 已购买的课程接口
	 */
	@Log("已购买课程接口")
	@GetMapping("/getBuyedCourse")
	public Map<String,Object> getBuyedCourse(Long userId){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("flag", 0);
		List<SubcriberLogDO> list = courseService.getAllCourseByFlag(params);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(list.size()==0){
			resultMap.put("code", 1);
			resultMap.put("msg","购买课程为空!");
			resultMap.put("data",list);
		}
		else{
			resultMap.put("code", 0);
			resultMap.put("msg","");
			resultMap.put("data",list);
		}
		return  resultMap;
	}
	
	/**
	 * 已转发/收藏的课程接口
	 */
	@Log("已转发/收藏课程接口")
	@GetMapping("/getCollectOrRelay")
	public Map<String,Object> getCollectOrRelay(Long userId,Integer flag){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("flag", flag);
		List<SubcriberLogDO> list = courseService.getAllCourseByFlag(params);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(list.size()==0){
			resultMap.put("code", 1);
			resultMap.put("msg","课程为空!");
			resultMap.put("data",list);
		}
		else{
			resultMap.put("code", 0);
			resultMap.put("msg","");
			resultMap.put("data",list);
		}
		return  resultMap;
	}
	
	/**
	 * 最近使用过的课程接口
	 */
	
	@Log("最近使用的课程接口")
	@GetMapping("/getUserCourseNearfuture")
	public Map<String,Object> getUserCourseNearfuture(Long userId){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		List<PlayRecordDO> list = courseService.getPlayRecord(params);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(list.size()==0){
			resultMap.put("code", 1);
			resultMap.put("msg","您没有播放过课程!");
			resultMap.put("data",list);
		}
		else{
			resultMap.put("code", 0);
			resultMap.put("msg","");
			resultMap.put("data",list);
		}
		return resultMap;
	}
	
	/**
	 * 新增购买课程接口
	 */
	
	@Log("新增购买课程接口")
	@PostMapping("/saveSubcriberLog")
	public Map<String,Object> saveSubcriberLog(SubcriberLogDO subcriberLogDO){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CourseDO courseDO=courseService.getCourseByCourseId(subcriberLogDO.getCourseId());
		if(courseDO==null){
			resultMap.put("code", 1);
			resultMap.put("msg","该课程缺失");
		}
		else{
			subcriberLogDO.setFlag(0);
			subcriberLogDO.setUpdateTime(new Date());
			subcriberLogDO.setCourseCover(courseDO.getCourseCover());
			subcriberLogDO.setName(courseDO.getName());
			subcriberLogDO.setChapterNum(courseDO.getChapterNum());
			subcriberLogDO.setCourseName(courseDO.getCourseName());
			subcriberLogDO.setUpdateTime(new Date());
			int result=courseService.saveSubcriberLog(subcriberLogDO);
			if(result>0){
				resultMap.put("code", 0);
				resultMap.put("msg","保存成功");
			}
		}
		
		return resultMap;
	}
	
	@Log("新增转发收藏的课程章节接口")
	@PostMapping("/saveCollectOrRelay")
	public Map<String,Object> saveCollectOrRelay(SubcriberLogDO subcriberLogDO){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CourseDO courseDO=courseService.getCourseByCourseId(subcriberLogDO.getCourseId());
		if(courseDO==null){
			resultMap.put("code", 1);
			resultMap.put("msg","该课程缺失");
		}
		else{
			subcriberLogDO.setUpdateTime(new Date());
			subcriberLogDO.setCourseCover(courseDO.getCourseCover());
			subcriberLogDO.setName(courseDO.getName());
			subcriberLogDO.setChapterNum(courseDO.getChapterNum());
			subcriberLogDO.setCourseName(courseDO.getCourseName());
			subcriberLogDO.setUpdateTime(new Date());
			int result=courseService.saveSubcriberLog(subcriberLogDO);
			if(result>0){
				resultMap.put("code", 0);
				resultMap.put("msg","保存成功");
			}
		}
		
		return resultMap;
	}
	
	/**
	 * 添加播放记录
	 */
	@Log("新增播放记录")
	@PostMapping("/savePlayRecord")
	public Map<String,Object> savePlayRecord(PlayRecordDO playRecordDO){
		PlayRecordDO po = courseService.getLastPlayRecord(playRecordDO.getUserId());//获取最后一次记录数据
		playRecordDO.setCreateTime(new Date());
		playRecordDO.setDeleteFlag(0);
		courseService.savePlayRecord(playRecordDO);
		subscriberService.updateStudyTime(playRecordDO.getPlayedTime(),playRecordDO.getUserId());
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(po.getCreateTime());
		int day1=calendar.get(Calendar.DAY_OF_YEAR);
		if(day!=day1){//新的一天，啊 哇嘎嘎嘎
			subscriberService.updateIfContinue(playRecordDO.getUserId(),playRecordDO.getCreateTime());
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg","succes");
		return map;
	}
	
	/**
	 * 根据输入模糊查询课程名
	 */
	@Log("根据输入模糊查询课程名")
	@GetMapping("/getCourseDim")
	public Map<String,Object> getCourseDim(String input){
		Map<String,Object> map=new HashMap<String,Object>();
		List<CourseDO> list = courseService.getCourseDim(input);
	
			map.put("code", 0);
			map.put("msg","sucess");
			map.put("data",list);
		
		
		return map;
	}
}

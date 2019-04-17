package com.zhenjiu.data.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhenjiu.common.utils.ShiroUtils;
import com.zhenjiu.data.domain.DataDO;
import com.zhenjiu.data.service.DataService;



/**
 * 
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-03-01 14:48:35
 */
 
@RestController
@RequestMapping("/zhenjiu/data")
public class DataController {
	private static final String  PARSE_DATE_STRING="yyyy-MM-dd hh:mm:ss";
	private static final String PARSE_END_STRING="yyyy-MM-dd 23:59:59";
	private static final String PARSE_START_STRING="yyyy-MM-dd 00:00:00";
	private static final String PARSE_SHORT_STRING="yyyy-MM-dd";
	private static final String[] WEEK={"0","一","二","三","四","五","六","日"};
	private static final String[] MONTH={"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
	@Autowired
	private DataService dataService;
	/**
	 * 治疗数据添加接口
	 */
	@PostMapping("/add")
	Map<String,Object> add(DataDO datado){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(datado);
		if(datado.getTreatTime()>0){
			datado.setAdddate(new Date());
			datado.setUserid(ShiroUtils.getUser().getUserId());
			if(dataService.save(datado)>0)
				map.put("msg","保存成功");
		}
		else
			map.put("msg","保存失败");
		return map;
	}
	/**
	 * 获取上一次治疗数据
	 * */
	
	@GetMapping("/getLastData") 
	Map<String,Object> getLastData(){
		List<DataDO> list = dataService.getLastData(ShiroUtils.getUser().getUserId());
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		map.put("treatStrength", list.get(0).getTreatStrength());
		map.put("treatWaveform", list.get(0).getTreatWaveform());
		map.put("treatWorkmethod", list.get(0).getTreatWorkmethod());
		map.put("treatTime", list.get(0).getTreatTime());
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("data", map);
		
		return map1;
	}
	
	
	/**
	 * 获取当前四天的数据接口
	 */
	
	@GetMapping("/getFourData")
	Map<String,Object> getFourData(){
       Date endDate = new Date();
       Calendar calendar=Calendar.getInstance();
       calendar.setTime(endDate);
       calendar.add(Calendar.DAY_OF_YEAR,-3);
       calendar.set(Calendar.HOUR_OF_DAY, 0);
       calendar.set(Calendar.MINUTE, 0);
       calendar.set(Calendar.SECOND, 0);
       Date startDate =  calendar.getTime();
       List<DataDO> list = dataService.getTreeDataByDate(ShiroUtils.getUser().getUserId(),startDate,endDate);
       Map<String,Object> map = getData(list,-1);
       
       return map;
	}
	
	/**
	 * 获取历史治疗数据
	 * flag 0 查询一周内的数据  1查询一月内的数据   2查询一年内的数据
	 */
	@GetMapping("/getHistoryData")
	Map<String,Object> getHistoryData(Integer flag){
		Map<String,Object> map = new HashMap<String,Object>();
		Calendar calendar = null;
		Date startDate=null;
		Date endDate=null;
		List<DataDO> list  = null;
		try {
			if(flag==0){//周
				calendar = Calendar.getInstance();  
				calendar.setFirstDayOfWeek(Calendar.MONDAY);  
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
				startDate = new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_START_STRING).format(calendar.getTime()));
				calendar = Calendar.getInstance();
				calendar.setFirstDayOfWeek(Calendar.MONDAY);  
		        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
				endDate = new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_END_STRING).format(calendar.getTime()));
				list = dataService.getTreeDataByDate(ShiroUtils.getUser().getUserId(), startDate, endDate);
				map = getData(list,flag);
			}
			else if(flag==1){//月
				calendar = Calendar.getInstance();
				calendar.set(Calendar.DATE, 1);
				startDate =new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_START_STRING).format(calendar.getTime()));
				calendar = Calendar.getInstance();
				calendar.set(Calendar.DATE, 1); 
				calendar.add(Calendar.MONTH, 1); 
				calendar.add(Calendar.DATE, -1); 
				endDate = new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_END_STRING).format(calendar.getTime()));
				System.out.println(ShiroUtils.getUser().getUserId());
				list = dataService.getTreeDataByDate(ShiroUtils.getUser().getUserId(), startDate, endDate);
				map = getData(list,flag);
			}
			else if(flag==2){//年
				calendar = Calendar.getInstance();
			    calendar.set(Calendar.MONTH,0);
			    calendar.set(Calendar.DAY_OF_MONTH,1);
			    startDate=  new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_START_STRING).format(calendar.getTime()));
			    calendar = Calendar.getInstance();
			    calendar.add(Calendar.YEAR,1);
			    calendar.set(Calendar.MONTH,0);
			    calendar.set(Calendar.DAY_OF_MONTH,1);
				endDate = new SimpleDateFormat(PARSE_DATE_STRING).parse(new SimpleDateFormat(PARSE_END_STRING).format(calendar.getTime()));
				list = dataService.getTreeDataByDate(ShiroUtils.getUser().getUserId(), startDate, endDate);
				map = getData(list,flag);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 获取治疗的平均时长和治疗次数
	 */
	public  Map<String,Object> getData(List<DataDO> list,int flag){
		List<AverageData> al = new ArrayList<AverageData>();
		Map<String,Integer> freMap = new LinkedHashMap<String,Integer>();
	    Map<String,Integer> treatMap = new LinkedHashMap<String,Integer>();
	    Set<String> sett = new HashSet<String>();
	    int avtime=0,avfre=0,day=0;//平均时长/平均次数/治疗天数
	    if(list!=null && list.size()>0){
	    	
	    	if(flag==-1){//统计当前四天
	    		Calendar calendar = Calendar.getInstance();
	    		
	    		Date nowdate = calendar.getTime();
	    		freMap.put(new SimpleDateFormat("MM/dd").format(nowdate),0);
	    		treatMap.put(new SimpleDateFormat("MM/dd").format(nowdate),0);
	    		
	    		calendar.add(Calendar.DAY_OF_YEAR, -1);
	    		Date yesdate = calendar.getTime();
	    		freMap.put(new SimpleDateFormat("MM/dd").format(yesdate),0);
	    		treatMap.put(new SimpleDateFormat("MM/dd").format(yesdate),0);
	    		
	    		calendar.add(Calendar.DAY_OF_YEAR, -1);
	    		Date tbyesdate = calendar.getTime();
	    		freMap.put(new SimpleDateFormat("MM/dd").format(tbyesdate),0);
	    		treatMap.put(new SimpleDateFormat("MM/dd").format(tbyesdate),0);
	    		
	    		calendar.add(Calendar.DAY_OF_YEAR, -1);
	    		Date fourdayagodate = calendar.getTime();
	    		freMap.put(new SimpleDateFormat("MM/dd").format(fourdayagodate),0);
	    		treatMap.put(new SimpleDateFormat("MM/dd").format(fourdayagodate),0);
	    		
	    		for(DataDO dataDO :list){
	    			String str = new SimpleDateFormat("MM/dd").format(dataDO.getAdddate());
	    			freMap.put(str, freMap.get(str)+1);
	    			treatMap.put(str,treatMap.get(str)+dataDO.getTreatTime());
	    		}
	    		Set<String> set = freMap.keySet();
	    		for(String str1 : set){
	    			AverageData a  = new AverageData();
	    			a.setTime(str1);
	    			a.setFrequency(freMap.get(str1));
	    			a.setAvtreatTime(treatMap.get(str1)==0?0:treatMap.get(str1)/a.getFrequency());
	    			al.add(a);
	    		}
	    	}else if(flag==-2){
	    		
	    		
	    	}else if(flag==0){//统计本周
	    		day=7;
	    		for(int i=1;i<=7;i++){//初始化
	    			freMap.put(WEEK[i],0);
	    			treatMap.put(WEEK[i],0);
	    		}
	    		for(DataDO dataDO :list){
	    			Calendar calendar = Calendar.getInstance();
	    			calendar.setTime(dataDO.getAdddate());
	    			Integer kz = calendar.get(Calendar.DAY_OF_WEEK)-1;
	    			if(kz==0) kz=7;
	    			freMap.put(WEEK[kz], freMap.get(WEEK[kz])+1);
	    			treatMap.put(WEEK[kz],treatMap.get(WEEK[kz])+dataDO.getTreatTime());
	    			sett.add(new SimpleDateFormat(PARSE_SHORT_STRING).format(dataDO.getAdddate()));
	    			avtime+=dataDO.getTreatTime();
	    			avfre++;
	    		}
	    		Set<String> set = freMap.keySet();
	    		for(String str1 : set){
	    			AverageData a  = new AverageData();
	    			a.setTime(str1);
	    			a.setFrequency(freMap.get(str1));
	    			a.setAvtreatTime(freMap.get(str1)==0?0:treatMap.get(str1)/a.getFrequency());
	    			al.add(a);
	    		}
	    		avtime/=list.size();
		    	avfre/=day;
	    	}
	    	else if(flag==1){//统计本月
	    		day=30;
	    		for(int i=1; i<11;i++){//初始化
	    			freMap.put(String.valueOf(3*i),0);
	    			treatMap.put(String.valueOf(3*i),0);
	    		}
	    		for(DataDO dataDO :list){
	    			Calendar calendar = Calendar.getInstance();
	    			calendar.setTime(dataDO.getAdddate());
	    			Integer km=(calendar.get(Calendar.DAY_OF_MONTH)-1)/3+1;
	    			if(km==11) km=10;
	    			freMap.put(String.valueOf(3*km), freMap.get(String.valueOf(3*km))+1);
	    			treatMap.put(String.valueOf(3*km),treatMap.get(String.valueOf(3*km))+dataDO.getTreatTime());
	    			sett.add(new SimpleDateFormat(PARSE_SHORT_STRING).format(dataDO.getAdddate()));
	    			avtime+=dataDO.getTreatTime();
	    			avfre++;
	    		}
	    		Set<String> set = freMap.keySet();
	    		for(String str1 : set){
	    			AverageData a  = new AverageData();
	    			a.setTime(str1);
	    			a.setFrequency(freMap.get(str1)/3);
	    			a.setAvtreatTime(freMap.get(str1)==0?0:treatMap.get(str1)/freMap.get(str1));
	    			al.add(a);
	    		}
	    		avtime/=list.size();
		    	avfre/=day;
	    	}
	    	else if(flag==2){//统计本年度
	    		day=365;
	    		for(int i=0; i<12; i++){//初始化
	    			freMap.put(MONTH[i],0);
	    			treatMap.put(MONTH[i],0);
	    		}
	    		for(DataDO dataDO :list){
	    			Calendar calendar = Calendar.getInstance();
	    			calendar.setTime(dataDO.getAdddate());
	    			Integer ky=calendar.get(Calendar.MONTH);
	    			freMap.put(MONTH[ky], freMap.get(MONTH[ky])+1);
	    			treatMap.put(MONTH[ky],treatMap.get(MONTH[ky])+dataDO.getTreatTime());
	    			sett.add(new SimpleDateFormat(PARSE_SHORT_STRING).format(dataDO.getAdddate()));
	    			avtime+=dataDO.getTreatTime();
	    			avfre++;
	    		}
	    		Set<String> set = freMap.keySet();
	    		
	    		for(String str1 : set){
	    			AverageData a  = new AverageData();
	    			a.setTime(str1);
	    			a.setFrequency(freMap.get(str1)/30);
	    			a.setAvtreatTime(freMap.get(str1)==0?0:treatMap.get(str1)/freMap.get(str1));
	    			al.add(a);
	    		}
	    		avtime/=list.size();
		    	avfre/=day;
    		}
	    }
	    //计算平均次数和平均时长
	    Map<String,Object> map = new HashMap<String,Object>();
	    map.put("data", al);
	    if(flag==0 ||flag==1 || flag==2){
	    	map.put("avtime", avtime);
	    	map.put("avfre", avfre);
	    }
	    return map;
	}
	  static class AverageData{
	    	private String time;//治疗时间
	    	private Integer frequency;//治疗次数
	    	private Integer avtreatTime;//治疗平均时长
	    	public String getTime() {
	    		return time;
	    	}
	    	public void setTime(String time) {
	    		this.time = time;
	    	}
	    	public Integer getFrequency() {
	    		return frequency;
	    	}
	    	public void setFrequency(Integer frequency) {
	    		this.frequency = frequency;
	    	}
	    	public Integer getAvtreatTime() {
	    		return avtreatTime;
	    	}
	    	public void setAvtreatTime(Integer avtreatTime) {
	    		this.avtreatTime = avtreatTime;
	    	}
		}
}

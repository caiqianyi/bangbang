package com.bangbang.msg.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.msg.domain.MsgDO;

/**
 * 消息表
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-21 17:28:29
 */
@Mapper
public interface MsgDao {

	MsgDO get(Integer id);
	
	List<MsgDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MsgDO msg);
	
	int update(MsgDO msg);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

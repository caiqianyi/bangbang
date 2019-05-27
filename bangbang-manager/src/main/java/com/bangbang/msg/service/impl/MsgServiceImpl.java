package com.bangbang.msg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bangbang.msg.dao.MsgDao;
import com.bangbang.msg.domain.MsgDO;
import com.bangbang.msg.service.MsgService;

import java.util.List;
import java.util.Map;





@Service
public class MsgServiceImpl implements MsgService {
	@Autowired
	private MsgDao msgDao;
	
	@Override
	public MsgDO get(Long id){
		return msgDao.get(id);
	}
	
	@Override
	public List<MsgDO> list(Map<String, Object> map){
		return msgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return msgDao.count(map);
	}
	
	@Override
	public int save(MsgDO msg){
		return msgDao.save(msg);
	}
	
	@Override
	public int update(MsgDO msg){
		return msgDao.update(msg);
	}
	
	@Override
	public int remove(Long id){
		return msgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return msgDao.batchRemove(ids);
	}
	
}

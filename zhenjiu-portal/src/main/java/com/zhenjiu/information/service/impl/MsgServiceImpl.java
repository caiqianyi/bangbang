package com.zhenjiu.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zhenjiu.information.dao.MsgDao;
import com.zhenjiu.information.domain.MsgDO;
import com.zhenjiu.information.service.MsgService;



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
	public int remove(Integer id){
		return msgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return msgDao.batchRemove(ids);
	}

	@Override
	public List<Map<Object, String>> queryUserMsgList(Long userId) {
		return msgDao.queryUserMsgList(userId);
	}

	@Override
	public List<Map<Object, String>> queryUserMsgListNull(Map<String, Object> map) {
		return msgDao.queryUserMsgListNull(map);
	}

	@Override
	public MsgDO queryUserMsgId(Long id, Long forIds) {
		return msgDao.queryUserMsgId(id, forIds);
	}


	
}

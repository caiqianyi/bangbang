package com.dingshi.information.service.impl;

import com.dingshi.common.domain.LogDO;
import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.dingshi.information.dao.ConsultDao;
import com.dingshi.information.domain.ConsultDO;
import com.dingshi.information.service.ConsultService;



@Service
public class ConsultServiceImpl implements ConsultService {
	@Autowired
	private ConsultDao consultDao;
	
	@Override
	public ConsultDO get(Integer id){
		return consultDao.get(id);
	}
	
	@Override
	public PageDO<ConsultDO> list(Query query){
        int total = consultDao.count(query);
        List<ConsultDO> list = consultDao.list(query);
        PageDO<ConsultDO> page = new PageDO<>();
        page.setTotal(total);
        page.setRows(list);
        return page;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return consultDao.count(map);
	}
	
	@Override
	public int save(ConsultDO consult){
		return consultDao.save(consult);
	}
	
	@Override
	public int update(ConsultDO consult){
		return consultDao.update(consult);
	}
	
	@Override
	public int remove(Integer id){
		return consultDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return consultDao.batchRemove(ids);
	}
	
}

package com.zhenjiu.information.service;

import org.springframework.data.domain.Page;

import com.zhenjiu.common.domain.PageDO;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.information.domain.ConsultDO;

import java.util.List;
import java.util.Map;

/**
 * 咨询表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2018-04-13 14:42:52
 */
public interface ConsultService {
	
	ConsultDO get(Integer id);

	PageDO<ConsultDO> list(Query query);
	
	int count(Map<String, Object> map);
	
	int save(ConsultDO consult);
	
	int update(ConsultDO consult);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

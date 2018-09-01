package com.dingshi.information.service;

import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
import com.dingshi.information.domain.ConsultDO;
import org.springframework.data.domain.Page;

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

	PageDO<Map<String,Object>> list(Query query);
	
	int count(Map<String, Object> map);
	
	int save(ConsultDO consult);
	
	int update(ConsultDO consult);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

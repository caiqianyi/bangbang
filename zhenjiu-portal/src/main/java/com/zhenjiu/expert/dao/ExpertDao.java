package com.zhenjiu.expert.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhenjiu.expert.domain.ExpertDO;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-02-15 09:53:23
 */
@Mapper
public interface ExpertDao {

	ExpertDO get(Long id);
	
	List<ExpertDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ExpertDO expert);
	
	int update(ExpertDO expert);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}

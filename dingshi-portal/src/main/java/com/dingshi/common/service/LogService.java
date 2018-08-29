package com.dingshi.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dingshi.common.domain.LogDO;
import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}

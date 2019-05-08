package com.zhenjiu.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhenjiu.common.domain.LogDO;
import com.zhenjiu.common.domain.PageDO;
import com.zhenjiu.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}

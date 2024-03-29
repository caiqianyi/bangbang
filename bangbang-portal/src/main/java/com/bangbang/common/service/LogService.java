package com.bangbang.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bangbang.common.domain.LogDO;
import com.bangbang.common.domain.PageDO;
import com.bangbang.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}

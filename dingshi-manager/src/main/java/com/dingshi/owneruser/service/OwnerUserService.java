package com.dingshi.owneruser.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dingshi.owneruser.domain.OwnerUserDO;

@Service
public interface OwnerUserService {
	OwnerUserDO get(Long id);
	
	OwnerUserDO getup(OwnerUserDO user);


	List<OwnerUserDO> list(Map<String, Object> map);
	List<Map<String, Object>> exeList(Map<String, Object> map);

	int count(Map<String, Object> map);


	int update(OwnerUserDO user);

	int remove(Long userId);

	boolean exit(Map<String, Object> params);

}

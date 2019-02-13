package com.zhenjiu.system.service;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import com.zhenjiu.owneruser.domain.OwnerUserDO;
import com.zhenjiu.system.domain.UserOnline;

@Service
public interface SessionService {
	List<UserOnline> list();

	List<OwnerUserDO> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}

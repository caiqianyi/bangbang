package com.dingshi.common.controller;

import org.springframework.stereotype.Controller;

import com.dingshi.common.utils.ShiroUtils;
import com.dingshi.owneruser.domain.OwnerUserDO;
import com.dingshi.system.domain.UserToken;

@Controller
public class BaseController {
	public OwnerUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
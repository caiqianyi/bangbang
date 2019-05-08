package com.bangbang.common.controller;

import org.springframework.stereotype.Controller;

import com.bangbang.common.utils.ShiroUtils;
import com.bangbang.owneruser.domain.OwnerUserDO;
import com.bangbang.system.domain.UserToken;

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
	public Long getforIds() {
		return getUser().getUserId();
	}
}
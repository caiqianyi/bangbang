package com.bangbang.common.controller;

import org.springframework.stereotype.Controller;

import com.bangbang.common.utils.ShiroUtils;
import com.bangbang.system.domain.UserDO;
import com.bangbang.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
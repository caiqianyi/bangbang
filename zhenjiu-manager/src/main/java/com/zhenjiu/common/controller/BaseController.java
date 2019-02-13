package com.zhenjiu.common.controller;

import org.springframework.stereotype.Controller;

import com.zhenjiu.common.utils.ShiroUtils;
import com.zhenjiu.system.domain.UserDO;
import com.zhenjiu.system.domain.UserToken;

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
package com.zhenjiu.common.controller;

import org.springframework.stereotype.Controller;

import com.zhenjiu.common.utils.ShiroUtils;
import com.zhenjiu.owneruser.domain.OwnerUserDO;
import com.zhenjiu.system.domain.UserToken;

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
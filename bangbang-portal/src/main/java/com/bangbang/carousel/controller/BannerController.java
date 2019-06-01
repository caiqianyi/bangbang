package com.bangbang.carousel.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bangbang.carousel.domain.BannerDO;
import com.bangbang.carousel.service.BannerService;
import com.bangbang.common.config.BootdoConfig;
import com.bangbang.common.controller.BaseController;
import com.bangbang.common.domain.FileDO;
import com.bangbang.common.utils.FileType;
import com.bangbang.common.utils.FileUtil;
import com.bangbang.common.utils.PageUtils;
import com.bangbang.common.utils.Query;
import com.bangbang.common.utils.R;

/**
 * 轮播图
 * 
 * @author wjl
 */
@Controller
@RequestMapping("/carousel/banner")
public class BannerController extends BaseController {

	@Autowired
	private BannerService bannerService;

	@ResponseBody
	@GetMapping("/list")
	public Map<String, Object> list() {
		// 查询列表数据
		Map<String, Object> params = new HashMap<String, Object>();
		List<BannerDO> sysFileList = bannerService.list(params);
		params.put("code", 0);
		params.put("msg", "");
		params.put("data", sysFileList);
		return params;

	}
	

}

package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.RegisterAgreementDO;

/**
 * 注册协议
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 16:50:53
 */
public interface RegisterAgreementService {
	
	RegisterAgreementDO get(Integer id);
	
	List<RegisterAgreementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RegisterAgreementDO registerAgreement);
	
	int update(RegisterAgreementDO registerAgreement);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

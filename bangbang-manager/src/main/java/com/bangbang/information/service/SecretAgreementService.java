package com.bangbang.information.service;


import java.util.List;
import java.util.Map;

import com.bangbang.information.domain.SecretAgreementDO;

/**
 * 隐私协议
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-05-22 16:50:53
 */
public interface SecretAgreementService {
	
	SecretAgreementDO get(Integer id);
	
	List<SecretAgreementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SecretAgreementDO secretAgreement);
	
	int update(SecretAgreementDO secretAgreement);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

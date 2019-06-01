package com.bangbang.information.dao;

import org.apache.ibatis.annotations.Mapper;

import com.bangbang.information.domain.VersionManagementDO;

/**
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2019-04-16 09:53:33
 */
@Mapper
public interface VersionManagementDao {

	VersionManagementDO get(Integer id);
	
	
}

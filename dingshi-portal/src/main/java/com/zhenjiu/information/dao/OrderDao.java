package com.zhenjiu.information.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zhenjiu.common.utils.Query;
import com.zhenjiu.information.domain.OrderDO;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {

    List<OrderDO> listByDriver(Query query);

    int count(Map<String,Object> map);

    OrderDO get(Integer id);
}

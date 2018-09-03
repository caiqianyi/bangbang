package com.dingshi.information.dao;

import com.dingshi.common.utils.Query;
import com.dingshi.information.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {

    List<OrderDO> listByDriver(Query query);

    int count(Map<String,Object> map);

    OrderDO get(Integer id);
}

package com.dingshi.information.service;

import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
import com.dingshi.information.domain.OrderDO;

import java.util.List;

public interface OrderService {

    PageDO<OrderDO> listByDriver(Query query);

    OrderDO get(Integer id);

}

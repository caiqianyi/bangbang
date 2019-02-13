package com.zhenjiu.information.service;

import java.util.List;

import com.zhenjiu.common.domain.PageDO;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.information.domain.OrderDO;

public interface OrderService {

    PageDO<OrderDO> listByDriver(Query query);

    OrderDO get(Integer id);

}

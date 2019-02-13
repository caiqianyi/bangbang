package com.zhenjiu.information.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenjiu.common.domain.PageDO;
import com.zhenjiu.common.utils.Query;
import com.zhenjiu.information.dao.OrderDao;
import com.zhenjiu.information.domain.ConsultDO;
import com.zhenjiu.information.domain.OrderDO;
import com.zhenjiu.information.service.OrderService;

import java.util.List;

/**
 * @Auth:wuqiang
 * @Description:
 * @Date:2018/9/1 12:25
 * @Version:1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public PageDO<OrderDO> listByDriver(Query query){
        int total = orderDao.count(query);
        List<OrderDO> list = orderDao.listByDriver(query);
        PageDO<OrderDO> page = new PageDO<>();
        page.setTotal(total);
        page.setRows(list);
        return page;
    }

    @Override
    public OrderDO get(Integer id) {
        return orderDao.get(id);
    }


}

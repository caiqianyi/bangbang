package com.dingshi.information.controller;

import com.dingshi.common.annotation.Log;
import com.dingshi.common.controller.BaseController;
import com.dingshi.common.domain.PageDO;
import com.dingshi.common.utils.Query;
import com.dingshi.information.domain.OrderDO;
import com.dingshi.information.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auth:wuqiang
 * @Description:
 * @Date:2018/9/1 12:05
 * @Version:1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    @Log("我的订单")
    @GetMapping("/listById")
    Map<String, Object> msgList(@RequestParam Map<String, Object> params){
        Map<String, Object> map = new HashMap<String, Object>();
        params.put("deleteFlag", 1);
        params.put("driverId",getUserId());
        Query query = new Query(params);
        PageDO<OrderDO> page = orderService.listByDriver(query);
        map.put("msg",page);
        return map;
    }

    @Log("订单列表")
    @GetMapping("/list")
    Map<String, Object> list(@RequestParam Map<String, Object> params){
        Map<String, Object> map = new HashMap<String, Object>();
        params.put("deleteFlag", 1);
        Query query = new Query(params);
        PageDO<OrderDO> page = orderService.listByDriver(query);
        map.put("msg",page);
        return map;
    }

    @Log("订单列表")
    @GetMapping("/deatil")
    Map<String, Object> deatil(Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        OrderDO order = orderService.get(id);
        map.put("msg",order);
        return map;
    }
}

package com.gxy.sell.service;

import com.gxy.sell.dataobject.OrderMaster;
import com.gxy.sell.dto.OrderDTO;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author GUO
 * @Classname OrderService
 * @Description 订单业务层接口
 * @Date 2020/9/27 23:06
 */
public interface OrderService {

    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /*查询单个订单*/
    OrderDTO findOne(String orderId);
    /*查询订单列表*/
    Page<OrderDTO>findList(String buyerOpenid, Pageable pageable);
    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*订单完成*/
    OrderDTO finish(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
}

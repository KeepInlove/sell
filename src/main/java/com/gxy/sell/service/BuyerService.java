package com.gxy.sell.service;

import com.gxy.sell.dto.OrderDTO;

/**
 * @author GUO
 * @Classname BuyerService
 * @Description TODO
 * @Date 2020/10/5 22:09
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOneOrder(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}

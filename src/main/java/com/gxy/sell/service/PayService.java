package com.gxy.sell.service;

import com.gxy.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author GUO
 * @Classname PayService
 * @Description TODO
 * @Date 2021/4/27 23:56
 */
public interface PayService {
    //发起支付
    PayResponse create(OrderDTO orderDTO);
    //支付回调
    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}

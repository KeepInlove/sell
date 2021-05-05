package com.gxy.sell.service.impl;

import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.service.OrderService;
import com.gxy.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname PayServiceImplTest
 * @Description TODO
 * @Date 2021/4/28 0:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("2021042819125900000014");
        payService.create(orderDTO);
    }
    @Test
    public void refund(){
        OrderDTO orderDTO = orderService.findOne("1620117227542666116");
        payService.refund(orderDTO);
    }
}
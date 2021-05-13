package com.gxy.sell.service.impl;

import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.service.OrderService;
import com.gxy.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author GUO
 * @Classname PushMessageServiceImplTest
 * @Description TODO
 * @Date 2021/5/13 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() {
        OrderDTO one = orderService.findOne("1620185942063656514");
        pushMessageService.orderStatus(one);
    }
}
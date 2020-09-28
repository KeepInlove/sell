package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.OrderDetail;
import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname OrderServiceImplTest
 * @Description TODO
 * @Date 2020/9/28 12:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    private  final String BUYER_OPENID="a123456";
    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        //1.个人信息
        orderDTO.setBuyerName("李四");
        orderDTO.setBuyerAddress("南京工业职业技术大学");
        orderDTO.setBuyerPhone("15083195736");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //2.购物车
        List<OrderDetail>orderDetailList=new ArrayList<>();
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setProductId("a123456");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}
package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.OrderDetail;
import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private  final String ORDER_ID="1601345064207232516";
    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        //1.个人信息
        orderDTO.setBuyerName("郭一");
        orderDTO.setBuyerAddress("南京工业职业技术大学");
        orderDTO.setBuyerPhone("15083195736");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //2.购物车
        List<OrderDetail>orderDetailList=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("b123456");
        o1.setProductQuantity(1);

        OrderDetail o2=new OrderDetail();
        o2.setProductId("c123456");
        o2.setProductQuantity(1);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);

    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result{}",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request=PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
//        System.out.println(orderDTOPage);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
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
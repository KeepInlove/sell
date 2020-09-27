package com.gxy.sell.repository;

import com.gxy.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname OrderDetailRepositoryTest
 * @Description TODO
 * @Date 2020/9/27 21:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("b20200001");
        orderDetail.setOrderId("d20200001");
        orderDetail.setProductId("a123456");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("小米10至尊版");
        orderDetail.setProductPrice(new BigDecimal(5299.00));
        orderDetail.setProductQuantity(1);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("d20200001");
//        System.out.println(orderDetailList);
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
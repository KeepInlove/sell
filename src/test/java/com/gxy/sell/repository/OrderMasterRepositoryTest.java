package com.gxy.sell.repository;

import com.gxy.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname OrderMasterRepositoryTest
 * @Description TODO
 * @Date 2020/9/27 20:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="a123456";
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("b123");
        orderMaster.setBuyerName("Guo");
        orderMaster.setBuyerPhone("12345678910");
        orderMaster.setBuyerAddress("南京工业职业技术大学");
        orderMaster.setBuyerOpenid("a123456");
        orderMaster.setOrderAmount(new BigDecimal(500));
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(1, 3);
        Page<OrderMaster> result= repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0,result.getTotalElements());
//        System.out.println(result.getTotalElements());
    }
}
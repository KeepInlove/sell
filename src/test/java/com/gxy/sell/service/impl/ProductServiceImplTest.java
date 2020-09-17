package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.ProductInfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname ProductServiceImplTest
 * @Description TODO
 * @Date 2020/9/15 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findById() {
        ProductInfo productInfo = productService.findById("a123456");
//        Assert.assertEquals("a",productInfo.getProductId());
        System.out.println(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productServiceUpAll = productService.findUpAll();
        Assert.assertNotEquals(0,productServiceUpAll.size());
    }

    @Test
    public void findAll() {
        PageRequest request=PageRequest.of(0,1);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("b123456");
        productInfo.setProductName("红米K30至尊版");
        productInfo.setProductPrice(new BigDecimal(1999));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很香");
        productInfo.setProductIcon("http:mu.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result=productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}
package com.gxy.sell.repository;

import com.gxy.sell.dataobject.ProductInfo;
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
 * @Classname ProductInfoRepositoryTest
 * @Description TODO
 * @Date 2020/9/15 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findByProductStatus() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("a123456");
        productInfo.setProductName("小米10至尊版");
        productInfo.setProductPrice(new BigDecimal(5299));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("安卓界的顶配");
        productInfo.setProductIcon("http:mu.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result=repository.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findProductStatus(){
        List<ProductInfo> productInfoList=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}
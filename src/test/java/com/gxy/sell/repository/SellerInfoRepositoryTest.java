package com.gxy.sell.repository;

import com.gxy.sell.dataobject.SellerInfo;
import com.gxy.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname SellerInfoRepositoryTest
 * @Description TODO
 * @Date 2021/5/9 20:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("123456");
//        sellerInfo.setOpenid("abc");
        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsernameAndPassword() {
        SellerInfo sellerInfo = sellerInfoRepository.findByUsernameAndPassword("admin","123456");
        System.out.println(sellerInfo);
    }
}
package com.gxy.sell;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.slf4j.Logger;

/**
 * @author GUO
 * @Classname LoggerTest
 * @Description TODO
 * @Date 2020/9/12 16:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
//@Data
public class LoggerTest {
    @Test
    public void test1(){
        log.debug("debug...");
        log.info("info...");
        String name="guo";
        String password="123456";
        log.info("name:"+name+"password:"+password);
        log.info("-----");
        log.info("name:{},password:{}",name,password);
        log.error("error...");
    }
}

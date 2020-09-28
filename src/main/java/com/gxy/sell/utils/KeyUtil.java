package com.gxy.sell.utils;

import java.util.Random;

/**
 * @author GUO
 * @Classname KeyUtil
 * @Description 生成订单详情id工具类
 * @Date 2020/9/28 11:07
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间加上随机数
     * @return
     */
    public static String getUniqueKey(){
        Random random=new Random();
        System.currentTimeMillis();
        Integer number= random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);

    }
}

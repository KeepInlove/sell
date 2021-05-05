package com.gxy.sell.utils;

import com.gxy.sell.enums.CodeEnum;

/**
 * @author GUO
 * @Classname EnumUtil
 * @Description 枚举工具类
 * @Date 2021/5/4 18:50
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T>enumClass){
        for (T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}

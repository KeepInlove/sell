package com.gxy.sell.enums;

import lombok.Getter;

/**
 * @author GUO
 * @Classname ProductStatusEnum
 * @Description TODO
 * @Date 2020/9/15 15:17
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0,"在售"),
    DOWN(1,"售馨");

    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message=message;
    }

}

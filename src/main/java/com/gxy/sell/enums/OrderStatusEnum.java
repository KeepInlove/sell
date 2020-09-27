package com.gxy.sell.enums;

import lombok.Getter;

/**
 * @author GUO
 * @Classname OrderStatusEnum
 * @Description TODO
 * @Date 2020/9/26 17:00
 */
@Getter
public enum OrderStatusEnum {
    NEW(1,"新订单"),
    FINISHED(2,"已支付"),
    CANCEL(0,"已取消");
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

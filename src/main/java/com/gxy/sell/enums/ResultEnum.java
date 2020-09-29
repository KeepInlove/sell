package com.gxy.sell.enums;

import lombok.Getter;

/**
 * @author GUO
 * @Classname ResultEnum
 * @Description TODO
 * @Date 2020/9/27 23:43
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(104,"商品不存在"),
    PRODUCT_NOT_ERROR(204,"库存不足"),
    ORDER_NOT_EXIST(304,"订单不存在");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

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
    PARAM_ERROR(04,"参数不正确"),
    CART_EMPTY(05,"购物车为空"),
    ORDER_OWNER_ERROR(06,"该订单不属于当前用户"),

    PRODUCT_NOT_EXIST(14,"商品不存在"),
    PRODUCT_NOT_ERROR(24,"库存不足"),

    ORDER_NOT_EXIST(34,"订单不存在"),
    ORDER_STATUS_ERROR(35,"订单状态不正确"),
    ORDER_UPDATE_FAIL(36,"订单更新失败"),
    ORDER_DETAIL_EMPTY(37,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(38,"订单支付状态不正确"),
    WXCHART_MP_ERROR(40,"微信公众账号错误");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

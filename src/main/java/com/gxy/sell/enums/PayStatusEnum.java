package com.gxy.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author GUO
 * @Classname PayStatusEnum
 * @Description TODO
 * @Date 2020/9/27 19:46
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

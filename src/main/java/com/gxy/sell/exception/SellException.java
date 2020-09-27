package com.gxy.sell.exception;

import com.gxy.sell.enums.ResultEnum;

/**
 * @author GUO
 * @Classname SellException
 * @Description 异常
 * @Date 2020/9/27 23:42
 */
public class SellException extends RuntimeException {
    private Integer code;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}

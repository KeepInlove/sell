package com.gxy.sell.dto;

import lombok.Data;

/**
 * @author GUO
 * @Classname CatDTO
 * @Description 购物车
 * @Date 2020/9/28 11:33
 */
@Data
public class CartDTO {
    /*商品id*/
    private String productId;
    /*数量*/
    private Integer productQuantity;
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

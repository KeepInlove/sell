package com.gxy.sell.dataobject;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author GUO
 * @Classname OrderDetail
 * @Description TODO
 * @Date 2020/9/27 19:52
 */
@Data
@Entity
public class OrderDetail {
    @Id
    private String detailId;
    /*订单id*/
    private String orderId;
    /*商品id*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*商品数量*/
    private Integer productQuantity;
    /*商品图片*/
    private String productIcon;

}

package com.gxy.sell.dataobject;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author GUO
 * @Classname ProductInfo
 * @Description 商品
 * @Date 2020/9/15 14:16
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /*名字*/
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*描述*/
    private String productDescription;
    /*商品小图*/
    private String productIcon;
    /*商品的状态,0正常,1下架*/
    private Integer productStatus;
    /*类目编号*/
    private Integer categoryType;

}

package com.gxy.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gxy.sell.enums.ProductStatusEnum;
import com.gxy.sell.utils.EnumUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GUO
 * @Classname ProductInfo
 * @Description 商品
 * @Date 2020/9/15 14:16
 */
@Entity
@Data
@DynamicInsert //属性为空不插入
@DynamicUpdate //更新为空不更新
public class ProductInfo implements Serializable {
    private static final long serialVersionUID = 6399186181668983148L;
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
//        修改时间
    private Date updateTime;
//    创建时间
    @CreatedDate
    private Date createTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}

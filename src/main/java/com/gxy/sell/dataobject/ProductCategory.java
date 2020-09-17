package com.gxy.sell.dataobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author GUO
 * @Classname ProductCategory
 * @Description TODO
 * @Date 2020/9/14 14:00
 * product_category
 */
@Entity
@DynamicUpdate  //数据库时间更新
@Data
public class ProductCategory {
    /*类目id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /*类目的名字*/
    private String categoryName;
    /*类目编号*/
    private Integer categoryType;
 /*   修改时间
    private Date updateTime;
    创建时间
    private Date createTime;
    */
    public ProductCategory(){}
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}

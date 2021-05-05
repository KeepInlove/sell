package com.gxy.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author GUO
 * @Classname ProductVO
 * @Description TODO
 * @Date 2020/9/20 21:12
 */
@Data
@ApiModel(description = "返回商品列表信息")
public class ProductVO {
    @ApiModelProperty("种类名字")
    @JsonProperty("name")
    private String  categoryName;
    @JsonProperty("type")
    @ApiModelProperty("分类编号")
    private Integer categoryType;
    @JsonProperty("foods")
    @ApiModelProperty("商品列表")
    private List<ProductInfoVO> productInfoVOS;
}

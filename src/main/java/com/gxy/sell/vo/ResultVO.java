package com.gxy.sell.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author GUO
 * @Classname ResultVO
 * @Description Http请求返回的最外层对象
 * @Date 2020/9/17 14:29
 */
@Data
@ApiModel(description = "返回值信息")
public class ResultVO<T> {
    /*状态码*/
    @ApiModelProperty("状态码")
    private  Integer code;
    /*提示信息*/
    @ApiModelProperty("提示信息")
    private String msg;
    /*具体内容*/
    private T data;
}

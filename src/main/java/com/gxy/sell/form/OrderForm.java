package com.gxy.sell.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.validation.constraints.NotEmpty;


/**
 * @author GUO
 * @Classname OrderForm
 * @Description TODO
 * @Date 2020/10/4 23:49
 */
@Data
@ApiModel(description = "表单信息")
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "手机号必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;
}

package com.gxy.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gxy.sell.dataobject.OrderDetail;
import com.gxy.sell.enums.OrderStatusEnum;
import com.gxy.sell.enums.PayStatusEnum;
import com.gxy.sell.utils.EnumUtil;
import com.gxy.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname OrderDTO
 * @Description 订单数据传输对象
 * @Date 2020/9/27 23:22
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /*订单id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家手机号*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家微信OpenId*/
    private String buyerOpenid;
    /*买家总金额*/
    private BigDecimal orderAmount;
    /*订单状态,默认新下单*/
    private  Integer orderStatus= OrderStatusEnum.NEW.getCode();;
    /*支付状态,默认0未支付*/
    private Integer payStatus=PayStatusEnum.WAIT.getCode();;
    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail>orderDetailList;

    @JsonIgnore
    public  OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}

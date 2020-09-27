package com.gxy.sell.dataobject;

import com.gxy.sell.enums.OrderStatusEnum;
import com.gxy.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname OrderMaster
 * @Description TODO
 * @Date 2020/9/26 16:51
 */
@DynamicUpdate  //数据库时间更新
@Entity
@Data
public class OrderMaster {
    /*订单id*/
    @Id
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
    private  Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /*支付状态,默认0未支付*/
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
}

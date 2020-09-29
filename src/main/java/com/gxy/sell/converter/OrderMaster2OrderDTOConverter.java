package com.gxy.sell.converter;

import com.gxy.sell.dataobject.OrderMaster;
import com.gxy.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GUO
 * @Classname OrderMaster2OrderDTOConverter
 * @Description TODO
 * @Date 2020/9/29 10:44
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO>convert(List<OrderMaster>orderMasterList){
      return  orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}

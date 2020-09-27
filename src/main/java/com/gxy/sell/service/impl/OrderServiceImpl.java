package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.OrderDetail;
import com.gxy.sell.dataobject.ProductInfo;
import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.exception.SellException;
import com.gxy.sell.repository.OrderDetailRepository;
import com.gxy.sell.service.OrderService;
import com.gxy.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author GUO
 * @Classname OrderServiceImpl
 * @Description 订单业务层实现类
 * @Date 2020/9/27 23:28
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);
        //1.查询商品(数量,价格)
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
           //orderAmount= orderDetail.getProductPrice()*orderDetail.getProductQuantity(); //错误形式
            orderAmount= orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))//先计算某一件商品的总价
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId("");
            orderDetail.setOrderId("");
            orderDetailRepository.save(orderDetail);
        }
        //3.写入订单数据库(orderMaster和orderDetail)
        //4.扣掉库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}

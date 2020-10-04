package com.gxy.sell.controller;

import com.gxy.sell.converter.OrderForm2OrderDTOConverter;
import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.exception.SellException;
import com.gxy.sell.form.OrderForm;
import com.gxy.sell.service.OrderService;
import com.gxy.sell.service.impl.OrderServiceImpl;
import com.gxy.sell.utils.ResultVOUtil;
import com.gxy.sell.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GUO
 * @Classname BuyerOrderController
 * @Description TODO
 * @Date 2020/10/4 23:35
 */
@Api(tags = "买家订单接口")
@RestController
@RequestMapping("/api/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    OrderServiceImpl orderService;
    //创建订单
    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public ResultVO<Map<String,String>>create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String>map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    //订单详情
    //取消订单
}

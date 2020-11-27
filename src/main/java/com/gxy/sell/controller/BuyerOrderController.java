package com.gxy.sell.controller;

import com.gxy.sell.converter.OrderForm2OrderDTOConverter;
import com.gxy.sell.dto.OrderDTO;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.exception.SellException;
import com.gxy.sell.form.OrderForm;
import com.gxy.sell.service.BuyerService;
import com.gxy.sell.service.OrderService;
import com.gxy.sell.service.impl.OrderServiceImpl;
import com.gxy.sell.utils.ResultVOUtil;
import com.gxy.sell.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
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
    @ApiOperation(value = "订单列表")
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>>listResultVO(@RequestParam("openid") String openid,
                                                @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                @RequestParam(value = "size",defaultValue = "10") Integer size){

        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
//        orderDTOPage.getTotalElements();
        //转存


        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @ApiOperation(value = "订单详情")
    @GetMapping("/detail")
    public ResultVO<OrderDTO>detail(@RequestParam("openid")String openid,
                                    @RequestParam("orderId")String orderId){
        //TODO
        OrderDTO orderDTO=buyerService.findOneOrder(openid,orderId);
        return ResultVOUtil.success(orderDTO);

    }
    //取消订单
    @ApiOperation(value = "取消订单")
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid")String openid,
                           @RequestParam("orderId")String orderId){
        //TODO 不安全做法,需要改进
//        OrderDTO orderDTO = orderService.findOne(orderId);
//        orderService.cancel(orderDTO);
        //改进后
        buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success();
    }

}

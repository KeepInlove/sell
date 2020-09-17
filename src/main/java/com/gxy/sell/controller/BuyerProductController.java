package com.gxy.sell.controller;

import com.gxy.sell.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GUO
 * @Classname BuyerProductController
 * @Description TODO
 * @Date 2020/9/17 14:09
 */
@RestController
@Api(tags = "买家接口模块")
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @ApiOperation(value = "查询所以已上架商品")
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }
}

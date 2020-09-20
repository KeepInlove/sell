package com.gxy.sell.controller;

import com.gxy.sell.dataobject.ProductCategory;
import com.gxy.sell.dataobject.ProductInfo;
import com.gxy.sell.service.CategoryService;
import com.gxy.sell.service.ProductService;
import com.gxy.sell.utils.ResultVOUtil;
import com.gxy.sell.vo.ProductInfoVO;
import com.gxy.sell.vo.ProductVO;
import com.gxy.sell.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @ApiOperation(value = "查询所以已上架商品")
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所以的上架的商品信息列表
        List<ProductInfo>productInfoList=productService.findUpAll();
        //2.查询类目(一次性查询)
        //2.1传统方法
//        List<Integer>categoryTypeList=new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList){
//           categoryTypeList.add(productInfo.getCategoryType());
//        }
        //2.2精简方法(java8,lambda) 通过查询上架的商品获取商品类目编号的列表
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        //通过商品类目编号查询类目的具体信息
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO>productVOList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO(); //实例化返回商品对象
            productVO.setCategoryName(productCategory.getCategoryName());//设置返回商品的种类名称
            productVO.setCategoryType(productCategory.getCategoryType());//设置返回商品种类的分类编号

            List<ProductInfoVO>productInfoVOList=new ArrayList<>(); //初始化返回商品具体信息列表
            for (ProductInfo productInfo:productInfoList){  //遍历商品信息列表
                //判断通过查询上架的商品类目编号与通过商品类目编号查询类目的具体信息的类目是否相等,存到相同的类目列表
               if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                   ProductInfoVO productInfoVO=new ProductInfoVO(); //实例化返回商品信息
                   BeanUtils.copyProperties(productInfo,productInfoVO);//复制商品的部分属性作为前端返回值传给前端返回对象
                   productInfoVOList.add(productInfoVO);//前端具体商品信息存入数组返回
               }
            }
            productVO.setProductInfoVOS(productInfoVOList);//添加商品的具体信息
            productVOList.add(productVO); //存入到相同商品类目编号列表
        }
//        ResultVO resultVO=new ResultVO();
//        ProductVO productVO=new ProductVO();
//        ProductInfoVO productInfoVO=new ProductInfoVO();
//        productVO.setProductInfoVOS(Arrays.asList(productInfoVO));
//        resultVO.setData(Arrays.asList(productVO));
//        resultVO.setCode(200);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);
        return ResultVOUtil.success(productVOList);
    }
}

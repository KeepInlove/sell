package com.gxy.sell.service;

import com.gxy.sell.dataobject.ProductInfo;
import com.gxy.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author GUO
 * @Classname ProductService
 * @Description TODO
 * @Date 2020/9/15 15:04
 */
public interface ProductService {

    ProductInfo findOne(String productId);
    /**
     * 查询所以在架商品
     * @return
     */
    List<ProductInfo> findUpAll();
    /*管理者,分面查询所以商品*/
    Page<ProductInfo> findAll(Pageable pageable);
    /*添加商品*/
    ProductInfo save(ProductInfo productInfo);
    /*加库存*/
    void addStock(List<CartDTO>catDTOList);
    /*减库存*/
    void decreaseStock(List<CartDTO>catDTOList);
    //上架
    ProductInfo onSale(String productId);
    //下架
    ProductInfo offSale(String productId);
}

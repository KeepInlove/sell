package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.ProductInfo;
import com.gxy.sell.enums.ProductStatusEnum;
import com.gxy.sell.repository.ProductInfoRepository;
import com.gxy.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname ProductServiceImpl
 * @Description TODO
 * @Date 2020/9/15 15:11
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).get();
    }

    /**
     * 查询所以在架商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 分页查询所以商品
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * 上架商品
     * @param productInfo
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}

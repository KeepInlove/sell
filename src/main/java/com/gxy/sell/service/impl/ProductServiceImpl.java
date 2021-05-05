package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.ProductInfo;
import com.gxy.sell.dto.CartDTO;
import com.gxy.sell.enums.ProductStatusEnum;
import com.gxy.sell.enums.ResultEnum;
import com.gxy.sell.exception.SellException;
import com.gxy.sell.repository.ProductInfoRepository;
import com.gxy.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public ProductInfo findOne(String productId) {
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
    /**
     * 上架商品数量
     * @param catDTOList
     */
    @Override
    @Transactional
    public void addStock(List<CartDTO> catDTOList) {
        for (CartDTO cartDTO:catDTOList){
            ProductInfo productInfo=repository.findById(cartDTO.getProductId()).get();
            if (productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }


    }

    /**
     * 减库存
     * @param catDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> catDTOList) {
        for (CartDTO cartDTO:catDTOList){
        ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
        if (productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        int result= productInfo.getProductStock() - cartDTO.getProductQuantity();
        //判断购物车商品是否大于库存的
        if (result<0){
            throw new SellException(ResultEnum.PRODUCT_NOT_ERROR);
        }
        productInfo.setProductStock(result);
        repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
       ProductInfo productInfo = repository.findById(productId).orElse(null);
       if (productInfo==null){
           throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
       }
       if (productInfo.getProductStatusEnum()==ProductStatusEnum.UP){
           throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
       }
       productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).orElse(null);
        if (productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}

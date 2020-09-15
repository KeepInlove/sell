package com.gxy.sell.repository;

import com.gxy.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author GUO
 * @Classname ProductInfoRepository
 * @Description TODO
 * @Date 2020/9/15 14:28
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

}

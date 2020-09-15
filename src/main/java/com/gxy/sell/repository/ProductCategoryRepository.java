package com.gxy.sell.repository;

import com.gxy.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @author GUO
 * @Classname ProductCategoryRepository
 * @Description TODO
 * @Date 2020/9/14 14:23
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryTypeList);

}

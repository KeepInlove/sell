package com.gxy.sell.service;

import com.gxy.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author GUO
 * @Classname CategoryService
 * @Description TODO
 * @Date 2020/9/15 13:25
 */
public interface CategoryService {
   ProductCategory findById(Integer categoryId);
   List<ProductCategory>findAll();
   List<ProductCategory>findByCategoryTypeIn(List<Integer> categoryTypeList);
   ProductCategory save(ProductCategory productCategory);
}

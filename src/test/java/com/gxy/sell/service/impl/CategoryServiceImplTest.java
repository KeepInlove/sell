package com.gxy.sell.service.impl;

import com.gxy.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.dc.pr.PRError;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname CategoryServiceImplTest
 * @Description TODO
 * @Date 2020/9/15 13:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findById() {
        ProductCategory result = categoryService.findById(1);
        Assert.assertEquals(new Integer(1),result.getCategoryId());
//        System.out.println(result);
    }

    @Test
    public void findAll() {
        List<ProductCategory>productCategoryList=categoryService.findAll();
        System.out.println(productCategoryList);
//        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryType() {
        List<ProductCategory>productCategoryList=categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        System.out.println(productCategoryList);
//        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory("男士专柜",4);
        ProductCategory result = categoryService.save(productCategory);
    }
}
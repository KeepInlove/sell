package com.gxy.sell.repository;

import com.gxy.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname ProductCategoryRepositoryTest
 * @Description TODO
 * @Date 2020/9/14 14:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory=repository.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    public void savaTest(){
        ProductCategory productCategory=new ProductCategory("女生最爱",3);
//        productCategory.setCreateTime(new Date());
//        productCategory.setUpdateTime(new Date());
        ProductCategory result= repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory=repository.findById(2).get();
        productCategory.setCategoryName("今日热销");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }
    @Test
    public void deleteTest(){
//        repository.deleteById(6);
    }
    @Test
    public void findBycCategoryTypeIn(){
        List<Integer>list= Arrays.asList(1,2,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}
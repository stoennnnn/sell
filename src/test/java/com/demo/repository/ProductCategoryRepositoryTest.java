package com.demo.repository;

import com.demo.SellApplication ;
import com.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2018-11-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    //@Qualifier("dao")
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public  void findOneTest(){
        ProductCategory category = repository.findOne(1);
        System.out.print(category.toString());

    }
    @Test
    public  void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("淘宝爆款");
        productCategory.setCategoryType("1");
        repository.save(productCategory);
    }
    @Test
    public  void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("淘宝爆款");
        productCategory.setCategoryType("1");
        repository.save(productCategory);
    }
}

package com.demo.repository;

import com.demo.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2018-11-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private  ProductCategoryRepository repository;

    @Test
    public  void findOneTest(){
        ProductCategory category = repository.findById(1).get();
        System.out.print(category.toString());
        System.out.println(1111);
        System.out.println(222);

    }
}
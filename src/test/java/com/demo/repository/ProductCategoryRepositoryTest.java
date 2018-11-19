package com.demo.repository;

import com.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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
        productCategory.setCategoryType(1);
        repository.save(productCategory);
    }
    //更新操作
    @Test
    public  void updateTest(){
        //先查出来
        ProductCategory  category = repository.findOne(3);
        category.setCategoryName("更新淘宝爆款3");
        category.setCategoryType(8);
        repository.save(category);
    }
    @Test
    public void  findByCategoryTypeIn(){
        List<Integer> list =Arrays.asList(2,3,4,8);
        List<ProductCategory> categorieList = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,categorieList.size());
    }
}

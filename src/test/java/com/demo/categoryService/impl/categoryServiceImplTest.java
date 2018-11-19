package com.demo.categoryService.impl;

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
 * Created by 张启磊 on 2018-11-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class categoryServiceImplTest {
    @Autowired
    private  categoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory categoryOne = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),categoryOne.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0,all.size());

    }

    @Test
    public void findCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findCategoryTypeIn(Arrays.asList(2, 3));
        Assert.assertNotEquals(0,list.size());

    }

    @Test
    public void save() throws Exception {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("京东爆款");
        category.setCategoryType(9);
        ProductCategory save = categoryService.save(category);
        Assert.assertNotNull(save);

    }

}
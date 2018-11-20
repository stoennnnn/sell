package com.demo.repository;

import com.demo.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 张启磊 on 2018-11-19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("22222222","网红尿",new BigDecimal(12.99),
        22,"全网最好喝的尿","www.google.com",8,1);
       ProductInfo save= repository.save(productInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByProductStatus(){
        List<ProductInfo> productList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productList.size());
    }
}
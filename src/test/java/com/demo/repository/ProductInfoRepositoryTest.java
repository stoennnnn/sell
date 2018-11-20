package com.demo.repository;

import com.demo.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

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
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("网红");
        productInfo.setProductId("22222");
        productInfo.setProductDescription("嗡嗡嗡");
        productInfo.setProductIcon("www.baidu.com");
        productInfo.setProductStock(12);
        productInfo.setProductPrice(new BigDecimal(12.22));
        productInfo.setProductstatus(0);
        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
    }
}
package com.demo.service.impl;

import com.demo.dataobject.ProductInfo;
import com.demo.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 26725 on 2018/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSericeImplTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findOne() {
       ProductInfo productInfo =  repository.findOne("11111111");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public  void findAll(){
        List<ProductInfo> productInfos = repository.findAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfos.size());
    }


    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("33333333", "网红脸", new BigDecimal(12.99),
                22, "全网最好看的脸", "www.buyaolian.com", 2, 0);
        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
    }
}
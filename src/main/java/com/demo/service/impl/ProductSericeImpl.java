package com.demo.service.impl;

import com.demo.dataobject.ProductInfo;
import com.demo.repository.ProductInfoRepository;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 26725 on 2018/11/20.
 */
@Service
public class ProductSericeImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return repository.findByProductStatus(productStatus);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo increaseStock() {
        return null;
    }
}

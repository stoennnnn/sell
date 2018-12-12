package com.demo.service;

import com.demo.dataobject.ProductInfo;
import com.demo.dto.CartDto;

import java.util.List;

/**
 * Created by 26725 on 2018/11/20.
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    List<ProductInfo> findAll();
    List<ProductInfo> findByProductStatus(Integer productStatus);
    ProductInfo save(ProductInfo productInfo);
    //加减库存
    void increaseStock(List<CartDto> list);
    void decreaseStock(List<CartDto> list);
}

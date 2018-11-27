package com.demo.service.impl;

import com.demo.dataobject.ProductInfo;
import com.demo.dto.CartDto;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
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
    public void increaseStock(List<CartDto> list) {

    }

    @Override
    public void decreaseStock(List<CartDto> list) {
        for (CartDto cartDto : list) {
            ProductInfo productInfo = findOne(cartDto.getProductId());
            if (productInfo==null)
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            Integer stock = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (stock<0)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            productInfo.setProductStock(stock);
            repository.save(productInfo);
        }
    }

}

package com.demo.service.impl;

import com.demo.dataobject.ProductInfo;
import com.demo.dto.OrderDto;
import com.demo.repository.ProductInfoRepository;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.math.BigDecimal;

/**
 * Created by 26725 on 2018/11/26.
 */
@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public OrderDto create(OrderDto dto) {
        //1根据商品id查询商品，价格只能从后台查询
        ProductInfo product = productInfoRepository.findOne(dto.getProductId());
        //计算总价
        BigDecimal buyermount = product.getProductPrice().multiply(new BigDecimal(dto.getProductQuantity()));
        //保存订单信息

        return null;
    }

    @Override
    public OrderDto findOne() {
        return null;
    }
}

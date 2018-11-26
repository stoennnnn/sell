package com.demo.service.impl;

import com.demo.dataobject.OrderDetail;
import com.demo.dataobject.OrderMaster;
import com.demo.dataobject.ProductInfo;
import com.demo.dto.CartDto;
import com.demo.dto.OrderDto;
import com.demo.enums.OrderStatus;
import com.demo.enums.PayStatus;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.repository.OrderDetailRepository;
import com.demo.repository.OrderMasterRepository;
import com.demo.repository.ProductInfoRepository;
import com.demo.service.OrderService;
import com.demo.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by 26725 on 2018/11/26.
 */
@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private  OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDto create(OrderDto dto) {
        //1根据商品id查询商品，价格只能从后台查询
        KeyUtils keyUtils = new KeyUtils();
        OrderMaster orderMaster = new OrderMaster();
        OrderDetail orderDetail = new OrderDetail();
        for (CartDto item : dto.getItems()) {
            ProductInfo product = productInfoRepository.findOne(item.getProductId());
            if (product==null)
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            //计算总价
            BigDecimal buyerMount = product.getProductPrice().multiply(new BigDecimal(item.getProductQuantity()));
            //保存订单明细
            String orderId = keyUtils.genUniqueKey();
            BeanUtils.copyProperties(item,orderDetail);
            orderDetail.setDetailId(keyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderMasterRepository.save(orderMaster);
        }
        //保存订单信息
        BeanUtils.copyProperties(dto,orderMaster);



        //修改库存
        ProductInfo productInfo = new ProductInfo();
        for (int i = 0; i < map.size(); i++) {
            productInfo.setProductId();
            productInfoRepository.save()
        }
    }

    @Override
    public OrderDto findOne() {
        return null;
    }
}

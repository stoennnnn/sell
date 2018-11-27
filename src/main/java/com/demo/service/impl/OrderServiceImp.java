package com.demo.service.impl;

import com.demo.converter.OrderMaster2OrderDtoConverter;
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
import com.demo.service.ProductService;
import com.demo.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by 26725 on 2018/11/26.
 */
@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 订单创建
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public OrderDto create(OrderDto dto) {
        //1根据商品id查询商品，价格只能从后台查询
        KeyUtils keyUtils = new KeyUtils();
        OrderMaster orderMaster = new OrderMaster();
        OrderDetail orderDetail = new OrderDetail();
        String orderId = keyUtils.genUniqueKey();
        BigDecimal buyerAmount = new BigDecimal(BigInteger.ZERO);
        for (CartDto item : dto.getItems()) {
            ProductInfo product = productService.findOne(item.getProductId());
            if (product == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算总价
            buyerAmount = product.getProductPrice().
                    multiply(new BigDecimal(item.getProductQuantity())).add(buyerAmount);
            //保存订单明细
            BeanUtils.copyProperties(product, orderDetail);
            orderDetail.setDetailId(keyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);
        }
        //保存订单信息
        BeanUtils.copyProperties(dto, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerAmount(buyerAmount);
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        //修改库存/lambda表达式
        List<CartDto> list = dto.getItems().stream()
                .map(e->new CartDto(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(list);
        return dto;
    }

    /**
     * 查询单个订单信息
     * @param orderId
     * @return
     */
    @Override
    public OrderDto findOne(String orderId) {
        //根据orderId查询订单主表
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (null==orderMaster)
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        OrderDto orderDto = OrderMaster2OrderDtoConverter.convert(orderMaster);
        //根据orderId查询订单明细表
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        if (null==orderDetails)
            throw  new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        orderDto.setOrderDetails(orderDetails);
        return orderDto;
    }

    /**
     * 根据openid查询用户订单列表
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDto> orderDtos = OrderMaster2OrderDtoConverter.convertList(orderMasters.getContent());
//        new PageImpl<>() pageImpl是oage的实现类

        return null;
    }


}

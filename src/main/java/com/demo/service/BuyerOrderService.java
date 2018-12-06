package com.demo.service;

import com.demo.dto.OrderDto;

/**
 * 买家订单service
 * Created by 26725 on 2018/12/6.
 */
public interface BuyerOrderService {
    OrderDto buyerOrderDetail(String openid,String orderId);
    OrderDto buyerOrderCancel(String openid,String orderId);
}

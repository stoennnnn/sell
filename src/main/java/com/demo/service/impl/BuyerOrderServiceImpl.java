package com.demo.service.impl;

import com.demo.dto.OrderDto;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.service.BuyerOrderService;
import com.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 26725 on 2018/12/6.
 */
@Service
@Slf4j
public class BuyerOrderServiceImpl implements BuyerOrderService{
    @Autowired
    private OrderService orderService;

    /**
     *
     * @param openid
     * @param orderId
     * @return
     */
    @Override
    public OrderDto buyerOrderDetail(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (null==orderDto){
            log.error("【买家订单明细】 订单不存在");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //校验openid
        if (!openid.equals(orderDto.getBuyerOpenid())){
            log.error("【买家订单明细】 openid错误");
            throw new SellException(ResultEnum.OPENID_ERROR);
        }
        return orderDto;

    }

    @Override
    public OrderDto buyerOrderCancel(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (null==orderDto){
            log.error("【买家订单取消】 订单不存在");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //校验openid
        if (!openid.equals(orderDto.getBuyerOpenid())){
            log.error("【买家订单明细】 openid错误");
            throw new SellException(ResultEnum.OPENID_ERROR);
        }
        //取消订单
        OrderDto resultDto = orderService.cancel(orderDto);
        return resultDto;
    }
}

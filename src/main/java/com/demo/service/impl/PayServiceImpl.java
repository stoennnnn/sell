package com.demo.service.impl;

import com.demo.dto.OrderDto;
import com.demo.service.PayService;
import com.demo.utils.JsonUtils;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by 26725 on 2018/12/19.
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    public static final String ORDER_NAME="weichat_order";
    @Autowired
    private BestPayServiceImpl payConfig;

    @Override
    public PayResponse creat(OrderDto orderDto) {
        PayRequest payRequest = new PayRequest();
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);//微信公众号支付
        payRequest.setOrderId(orderDto.getOrderId());
        payRequest.setOrderAmount(orderDto.getBuyerAmount().doubleValue());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setOpenid(orderDto.getBuyerOpenid());
        log.info("【微信支付】 payRequest={}",JsonUtils.toJson(payRequest));
        PayResponse payResponse = payConfig.pay(payRequest);
        log.info("【微信支付】 payResponse={}", JsonUtils.toJson(payResponse));
        return payResponse;
    }
}

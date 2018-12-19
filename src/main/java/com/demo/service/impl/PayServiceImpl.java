package com.demo.service.impl;

import com.demo.dto.OrderDto;
import com.demo.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 26725 on 2018/12/19.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public void creat(OrderDto orderDto) {
        PayRequest payRequest = new PayRequest();
        bestPayService.pay(payRequest);


    }
}

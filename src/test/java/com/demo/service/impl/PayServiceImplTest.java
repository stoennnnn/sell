package com.demo.service.impl;

import com.demo.controller.PayController;
import com.demo.dto.OrderDto;
import com.demo.service.PayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by 26725 on 2018/12/19.
 */
public class PayServiceImplTest {
    @Autowired
    private PayService payService;
    @Test
    public void creat() throws Exception {
        OrderDto orderDto = new OrderDto();
        payService.creat(orderDto);


    }

}
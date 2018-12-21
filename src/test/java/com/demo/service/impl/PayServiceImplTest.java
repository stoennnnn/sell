package com.demo.service.impl;

import com.demo.controller.PayController;
import com.demo.dto.OrderDto;
import com.demo.service.OrderService;
import com.demo.service.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 26725 on 2018/12/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayServiceImplTest {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    @Test
    public void creat() throws Exception {
        OrderDto orderDto = orderService.findOne("1544001202243114339");
        payService.creat(orderDto);


    }

}
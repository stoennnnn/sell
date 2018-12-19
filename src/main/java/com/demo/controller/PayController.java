package com.demo.controller;
import com.demo.dto.OrderDto;
import com.demo.service.PayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 支付controller
 ** Created by 26725 on 2018/12/19.
 **/

@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @GetMapping("/creat")
    public void creat(@RequestParam("orderId") String orderId,
                        @RequestParam("returnUrl") String returnUrl){



    }
}

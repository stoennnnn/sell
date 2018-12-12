package com.demo.service.impl;

import com.demo.dto.CartDto;
import com.demo.dto.OrderDto;
import com.demo.enums.OrderStatus;
import com.demo.enums.PayStatus;
import com.demo.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26725 on 2018/11/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImpTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void create() throws Exception {

        OrderDto orderDTO = new OrderDto();
        orderDTO.setBuyerName("张启磊");
        orderDTO.setBuyerAddress("成都市");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid("00908080981");
        //购物车
        List<CartDto> cartDtos = new ArrayList<>();
        CartDto o1 = new CartDto("11111111", 1);
        cartDtos.add(o1);
        orderDTO.setItems(cartDtos);
        OrderDto orderDto = orderService.create(orderDTO);
        Assert.assertNotNull(orderDto);
    }

    @Test
    public void findOne() throws Exception {
        OrderDto orderDto = orderService.findOne("1543301536456485560");
        Assert.assertNotNull(orderDto);
    }

    @Test
    public void findList(){
        PageRequest request = new PageRequest(0,5);
        Page<OrderDto> dtoPage = orderService.findList("wp123", request);
    }

//    @Test
//    public void cancel() throws Exception {
//        OrderDto orderDto =orderService.cancel();
//        orderService.cancel(orderDto);
//    }

    @Test
    public void finish() throws Exception {
        OrderDto one = orderService.findOne("1543301536456485560");
        OrderDto finish = orderService.finish(one);
        Assert.assertEquals(OrderStatus.FINISH.getCode(),finish.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDto one = orderService.findOne("1543301536456485560");
        OrderDto paid = orderService.paid(one);
        Assert.assertEquals(PayStatus.SUCCESS.getCode(),paid.getPayStatus());
    }
}
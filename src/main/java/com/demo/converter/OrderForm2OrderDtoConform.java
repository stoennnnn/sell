package com.demo.converter;

import com.demo.dto.CartDto;
import com.demo.dto.OrderDto;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.form.OrderForm;
import com.demo.utils.KeyUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启磊 on 2018-12-5.
 */
public class OrderForm2OrderDtoConform {
    public static OrderDto convert(OrderForm orderForm){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderForm,orderDto);
        String orderId = KeyUtils.genUniqueKey();
        orderDto.setOrderId(orderId);
        //json转List
        Gson gson = new Gson();
        List<CartDto> cartDtoList = new ArrayList<CartDto>();
        try {
            cartDtoList= gson.fromJson(orderForm.getItems(), new TypeToken<List<CartDto>>() {
            }.getType());
        }catch (Exception e){
            e.printStackTrace();
            throw  new SellException(ResultEnum.CART_EMPTY);
        }
        orderDto.setItems(cartDtoList);
        return  orderDto;
    }
}

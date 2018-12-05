package com.demo.controller;

import com.demo.VO.ResultVO;
import com.demo.converter.OrderForm2OrderDtoConform;
import com.demo.dto.OrderDto;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.form.OrderForm;
import com.demo.service.OrderService;
import com.demo.utils.ResutVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张启磊 on 2018-12-5.
 */
@Controller
@RequestMapping("/buyer/order")
@ResponseBody
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param result
     * @return
     */
    @RequestMapping("/creat")
    public ResultVO<Map<String,String>> creat(@Valid OrderForm orderForm, BindingResult result){
        if (result.hasErrors()){
            log.error("【创建订单】 参数不正确 orderForm={}",orderForm);
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        //转换
        OrderDto orderDto = OrderForm2OrderDtoConform.convert(orderForm);
        if (null==orderDto.getItems()){
            log.error("【创建订单】 购物车为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        //调用service
        OrderDto resultCreat = orderService.create(orderDto);
        Map<String, String> map = new HashMap<>();
        map.put("orderId",resultCreat.getOrderId());
        return  ResutVOUtil.success(map);
    }
}
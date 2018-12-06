package com.demo.controller;

import com.demo.VO.ResultVO;
import com.demo.converter.OrderForm2OrderDtoConform;
import com.demo.dto.OrderDto;
import com.demo.enums.ResultEnum;
import com.demo.exception.SellException;
import com.demo.form.OrderForm;
import com.demo.service.BuyerOrderService;
import com.demo.service.OrderService;
import com.demo.utils.ResutVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private BuyerOrderService buyerOrderService;

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

    /**
     * 订单列表
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public ResultVO<List<OrderDto>> list(@RequestParam("openid" )  String openid,
                                         @RequestParam(value="page" ,defaultValue="0") Integer page ,
                                         @RequestParam(value ="size" , defaultValue ="5" ) Integer size ){
        if (StringUtils.isEmpty("opendid")){
            log.error("【订单列表】 参数出错误");
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        Page<OrderDto> result = orderService.findList(openid,new PageRequest(page,size));
        List<OrderDto> list = result.getContent();
        return  ResutVOUtil.success(list);
    }

    /**
     * 订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @RequestMapping("/detail")
    public ResultVO<OrderDto> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        if (StringUtils.isEmpty(openid)||StringUtils.isEmpty(orderId)){
            log.error("【订单详情】 参数不正确");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDto orderDto = buyerOrderService.buyerOrderDetail(openid, orderId);
        return  ResutVOUtil.success(orderDto);

    }
    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @RequestMapping("/cancel")
    public ResultVO<OrderDto> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        if (StringUtils.isEmpty(openid)||StringUtils.isEmpty(orderId)){
            log.error("【订单取消】 参数不正确");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDto orderDto = buyerOrderService.buyerOrderCancel(openid, orderId);
        return  ResutVOUtil.success(orderDto);
    }
}

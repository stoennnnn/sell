package com.demo.converter;

import com.demo.dataobject.OrderMaster;
import com.demo.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by 26725 on 2018/11/27.
 */
public class OrderMaster2OrderDtoConverter {
    public static OrderDto convert(OrderMaster orderMaster){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return  orderDto;
    }

    public  static List<OrderDto> convertList(List<OrderMaster> orderMasters){
        return   orderMasters.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

}

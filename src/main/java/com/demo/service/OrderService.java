package com.demo.service;

import com.demo.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by 26725 on 2018/11/26.
 */
public interface OrderService {
    /** 新建订单 */
    OrderDto create(OrderDto dto);
    OrderDto findOne(String orderId);
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);
    OrderDto cancel(OrderDto orderDto);
}

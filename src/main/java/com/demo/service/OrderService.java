package com.demo.service;

import com.demo.dataobject.OrderMaster;
import com.demo.dto.OrderDto;

/**
 * Created by 26725 on 2018/11/26.
 */
public interface OrderService {
    /** 新建订单 */
    OrderDto create(OrderDto dto);
    OrderDto findOne();
}

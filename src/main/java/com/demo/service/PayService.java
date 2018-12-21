package com.demo.service;

import com.demo.dto.OrderDto;
import com.lly835.bestpay.model.PayResponse;

/**支付
 * Created by 26725 on 2018/12/19.
 */
public interface PayService {

    PayResponse creat(OrderDto orderDto);
}

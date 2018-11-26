package com.demo.dto;

import com.demo.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单dto
 * Created by 26725 on 2018/11/26.
 */
@Data
public class OrderDto {
    private String orderId;
    private String buyerNmae;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenId;
    private BigDecimal buyerAmount;
    private Integer orderStatus;
    private Integer payStatus;
    //订单明细列表
    private List<OrderDetail> orderDetails;
    //items列表
    private List<CartDto> items;

}

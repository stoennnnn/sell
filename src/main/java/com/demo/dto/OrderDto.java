package com.demo.dto;

import com.demo.dataobject.OrderDetail;
import com.demo.enums.OrderStatus;
import com.demo.enums.PayStatus;
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
    private List<OrderDetail> orderDetails;
    //商品id
    private  String productId ;
    //购买数量
    private Integer productQuantity;
}

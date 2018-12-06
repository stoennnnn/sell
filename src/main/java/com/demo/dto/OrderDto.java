package com.demo.dto;

import com.demo.dataobject.OrderDetail;
import com.demo.utils.serialize.Date2LongSerialize;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单dto
 * Created by 26725 on 2018/11/26.
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal buyerAmount;
    private Integer orderStatus;
    private Integer payStatus;
    //购物车参数集合
    private List<CartDto> items ;
    //订单明细列表
    private List<OrderDetail> orderDetails;
    //创建时间
    @JsonSerialize(using = Date2LongSerialize.class) //把时间转换秒级别
    private Date createTime;
    //修改时间
    @JsonSerialize(using = Date2LongSerialize.class)
    private  Date updateTime;

}

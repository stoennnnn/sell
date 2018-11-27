package com.demo.enums;


import lombok.Getter;

/**
 * Created by 张启磊 on 2018-11-26.
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品不正确"),
    ORDER_NOT_EXIST(12,"商品不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单明细不存在");
    private  Integer code;

    private String msg;
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

package com.demo.enums;


import lombok.Getter;

/**
 * Created by 张启磊 on 2018-11-26.
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"商品参数错误 "),
    CART_EMPTY(2,"购物车为空 "),

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品不正确"),
    ORDER_NOT_EXIST(12,"商品不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单明细不存在"),
    ORDER_STATUS_ERROR(14,"商品状态错误"),
    ORDER_UPDATE_ERROR(15,"商品状态更新失败"),
    ORDERDETAIL_EMPTY(16,"商品状态更新失败"),
    ORDER_PAY_STATUS_ERROR(17,"商品支付状态错误");
    private  Integer code;

    private String msg;
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

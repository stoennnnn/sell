package com.demo.enums;

import lombok.Getter;

/**
 * Created by 张启磊 on 2018-11-25.
 */
@Getter
public enum OrderStatus {
    NEW(0,"新订单"),
    FINISH(1,"完成订单"),
    DELETE(2,"删除订单");
    private Integer code;

    private  String msg;

    OrderStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

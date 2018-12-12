package com.demo.enums;

import lombok.Getter;

/**
 * 支付状态的枚举
 * Created by 张启磊 on 2018-11-25.
 */
@Getter
public enum PayStatus {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private  String msg;

    PayStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

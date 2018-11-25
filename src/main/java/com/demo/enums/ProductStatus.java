package com.demo.enums;

import lombok.Getter;

/**
 * Created by 张启磊 on 2018-11-25.
 */
@Getter
public enum ProductStatus {
    UP(0,"正常"),DOWN(1,"下架");
    private Integer code;
    private String msg;

    ProductStatus(Integer code ,String msg ) {
        this.msg = msg;
        this.code = code;
    }
}

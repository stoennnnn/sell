package com.demo.exception;

import com.demo.enums.ResultEnum;

/**
 * 异常处理
 * Created by 张启磊 on 2018-11-26.
 */
public class SellException  extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode() ;
    }
}

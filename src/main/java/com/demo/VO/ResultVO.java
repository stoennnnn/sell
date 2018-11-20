package com.demo.VO;

import lombok.Data;

/**
 * Created by 26725 on 2018/11/20.
 */
@Data
public class ResultVO<T> {
    private  String code;

    private  String msg ;

    private  T Data;
}

package com.demo.logTest;

import lombok.Getter;

/**
 * Created by 张启磊 on 2018-11-21.
 */
@Getter
public  enum  Animal{
    cat(1,"喵喵"),
    dog(2,"狗狗");
    //相当于定义常量
    private static final String cat2 = "1";
    private  Integer code;
    private  String  msg;
    Animal(Integer code,String msg) {
        this.code=code;
        this.msg =msg;
    }
}

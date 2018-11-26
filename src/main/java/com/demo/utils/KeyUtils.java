package com.demo.utils;

/**
 * Created by 张启磊 on 2018-11-26.
 */
public class KeyUtils {
    //生成orderId
    public  static String genUniqueKey(){
        //生成一个6位数的整数
        double random = (Math.random() * 9 + 1) * 100000;
        long timeMillis = System.currentTimeMillis();
        return timeMillis+random+"";
    }
}

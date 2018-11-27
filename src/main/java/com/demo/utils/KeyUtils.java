package com.demo.utils;

import java.util.Random;

/**
 * Created by 张启磊 on 2018-11-26.
 */
public class KeyUtils {
    //生成orderId
    public  static String genUniqueKey(){
        //生成一个6位数的整数
        int random = new Random().nextInt(900000)+100000;
        String timeMillis = System.currentTimeMillis()+"";
        return timeMillis+random;
    }
}

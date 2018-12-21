package com.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 转为json格式
 * Created by 26725 on 2018/12/20.
 */
public class JsonUtils {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return  gson.toJson(object);
    }

}

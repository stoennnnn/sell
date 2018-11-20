package com.demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by 26725 on 2018/11/20.
 */
public class ProductInfoVO {
    @JsonProperty("id")
    private String productId;
    @JsonProperty("name")
    private String prodctName;
    @JsonProperty("price")
    private String prodctPrice;
    @JsonProperty("description")
    private String productDescription;
    @JsonProperty ("icon")
    private  String productIcon;

}

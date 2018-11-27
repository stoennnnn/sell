package com.demo.dto;

import lombok.Data;

/**
 * Created by 张启磊 on 2018-11-26.
 */
@Data
public class CartDto {
    //s商品id
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

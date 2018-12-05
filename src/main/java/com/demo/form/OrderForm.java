package com.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * Created by 张启磊 on 2018-12-5.
 */
@Data
public class OrderForm {
    //买家名称
    @NotEmpty(message = "买家姓名为空")
    private String name;

    //买家电话
    @NotEmpty(message = "买家电话为空")
    private String phone;

    //买家地址
    @NotEmpty(message = "买家地址为空")
    private String address;

    //买家微信id
    @NotEmpty(message = "买家微信id为空")
    private String openid;

    //购物车信息
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
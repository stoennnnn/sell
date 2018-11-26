package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单详情实体类
 * Created by 张启磊 on 2018-11-25.
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    //商品名称
    private String productName;
    //商品价格
    private BigDecimal productPrice;
    //商品图片
    private String productIcon;


}

package com.demo.dataobject;

import com.demo.enums.OrderStatus;
import com.demo.enums.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 * Created by 张启磊 on 2018-11-25.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
    private  String  orderId;

    private String buyerName;

    private  String  buyerPhone;

    private String buyerAddress;
    //微信id
    private  String  buyerOpenid;

    private BigDecimal buyerAmount;

    //订单状态,默认0为新订单
    private Integer orderStatus  = OrderStatus.NEW.getCode();
    //支付状态,默认0待支付
    private Integer payStatus = PayStatus.WAIT.getCode();
    //创建时间
    private Date createTime;
    //修改时间
    private  Date updateTime;



}

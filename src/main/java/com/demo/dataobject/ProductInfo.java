package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by 张启磊 on 2018-11-19.
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {

    //产品id
    @Id
    private  String productId ;

    //产品名称
    private  String productName ;

    //产品价格
    private BigDecimal productPrice;

    //商品库存
    private Integer productStock ;

    //商品描述
    private  String productDescription ;

    //商品小图
    private  String productIcon ;

    //类目编号
    private  Integer categoryType;

    //商品状态 0 代表正常 1代表下架
    private  Integer productStatus;

    public  ProductInfo(){};
    public ProductInfo(String productId, String productName, BigDecimal productPrice,
                       Integer productStock, String productDescription, String productIcon,
                       Integer categoryType, Integer productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.categoryType = categoryType;
        this.productStatus = productStatus;
    }
}

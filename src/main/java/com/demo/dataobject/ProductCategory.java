package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目表
 * Created by 张启磊 on 2018-11-13
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    //类目
    @Id
@GeneratedValue
private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;


}
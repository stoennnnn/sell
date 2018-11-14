package com.demo.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目表
 * Created by 张启磊 on 2018-11-13.
 */
@Entity
public class ProductCategory {
    //类目
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private String categoryType;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
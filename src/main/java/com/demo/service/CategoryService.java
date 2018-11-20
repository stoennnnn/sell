package com.demo.service;

import com.demo.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by 张启磊 on 2018-11-15.
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory  save(ProductCategory category);
}

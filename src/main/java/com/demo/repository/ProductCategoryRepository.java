package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.dataobject.ProductCategory;

/**
 * Created by 张启磊 on 2018-11-13.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}

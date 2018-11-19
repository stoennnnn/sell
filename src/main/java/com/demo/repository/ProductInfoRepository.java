package com.demo.repository;

import com.demo.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 张启磊 on 2018-11-19.
 */
public interface  ProductInfoRepository  extends JpaRepository<ProductInfo,String>{
     List<ProductInfo> findByCategoryTypeStatus(Integer productInfoStastus );
}

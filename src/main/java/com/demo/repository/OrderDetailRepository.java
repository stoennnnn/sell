package com.demo.repository;

import com.demo.dataobject.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 张启磊 on 2018-11-25.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
    Page<OrderDetail> findByOrderId(String orderId , Pageable pageable);
}

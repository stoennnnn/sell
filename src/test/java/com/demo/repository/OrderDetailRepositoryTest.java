package com.demo.repository;

import com.demo.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2018-11-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void findByOrderId() throws Exception {
        //传一个分页参数
        PageRequest request = new PageRequest(0,2);
        Page<OrderDetail> orderDetails = repository.findByOrderId("12345", request);
        Assert.assertNotNull(orderDetails);
    }

}
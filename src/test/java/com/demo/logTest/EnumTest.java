package com.demo.logTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2018-11-21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumTest {
    @Test
    public  void  test(){
        Integer code = Animal.cat.getCode();
    }
}

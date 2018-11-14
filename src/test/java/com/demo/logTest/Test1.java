package com.demo.logTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Test1.class)
public class Test1 {
    private   final org.slf4j.Logger logger =  LoggerFactory.getLogger(Test1.class);
    @Test
    public void  test(){
        String name = "zzz";
        String pwd = "123456";
        logger.debug("我是debug");
        logger.error("我是error");
        logger.warn("我是warn");
        logger.info("我是info");
    }
}

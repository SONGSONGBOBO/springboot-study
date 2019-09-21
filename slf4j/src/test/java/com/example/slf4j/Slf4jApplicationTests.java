package com.example.slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Slf4jApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

        //日志级别 由低到高排列
        //可以调整输出的日志级别，日志只会在这个级别或者更高级别出现
        logger.trace("trace日志");
        logger.debug("debug");
        //springboot默认给我们输出info级别，在application.properties调整
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}

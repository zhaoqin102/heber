package com.muchu.heber.logger.test.rabbit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁海鹏
 * @createTime 17-1-1 下午10:54
 */
public class LogbackTest {

    private Logger logger = LoggerFactory.getLogger(LogbackTest.class);

//    @Test
    public void test01() {
        logger.info("rabbit Test");
    }
}

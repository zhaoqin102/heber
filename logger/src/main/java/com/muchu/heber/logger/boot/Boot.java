package com.muchu.heber.logger.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 梁海鹏
 * @createTime 2016/12/2 18:19
 */
public class Boot {

//    private static ClassPathXmlApplicationContext context;

    private static Logger logger = LoggerFactory.getLogger(Boot.class);

    public static void main(String[] args) {
        logger.info("logger开始启动");
//        context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
//        context.start();
        logger.info("logger启动成功");
        synchronized (Boot.class) {
            do {
                try {
                    Boot.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
}

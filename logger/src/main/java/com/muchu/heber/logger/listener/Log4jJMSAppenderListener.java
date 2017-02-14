package com.muchu.heber.logger.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author 梁海鹏
 * @createTime 2016/12/2 18:07
 */
public class Log4jJMSAppenderListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            // receive log event in your consumer
//            Log4jLogEvent event = (Log4jLogEvent) ((ActiveMQObjectMessage) message).getObject();
//            System.out.println("Received log [" + event.getLevel() + "]: " + event.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

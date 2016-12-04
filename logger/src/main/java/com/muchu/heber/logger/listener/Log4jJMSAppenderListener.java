package com.muchu.heber.logger.listener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;

import javax.jms.Message;
import javax.jms.MessageListener;

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
            String text = ((ActiveMQTextMessage) message).getText();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

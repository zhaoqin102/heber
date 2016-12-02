package com.muchu.heber.web.acitvemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.spi.LoggingEvent;

import javax.jms.*;

/**
 * @author 梁海鹏
 * @createTime 2016/12/2 17:17
 */
public class Log4jJMSAppenderExample implements MessageListener {

    public Log4jJMSAppenderExample() throws Exception {
        // create a logTopic topic consumer
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("failover:(tcp://192.168.2.211:61616)");
        factory.setTrustAllPackages(true);
        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        conn.start();
        MessageConsumer consumer = sess.createConsumer(sess.createTopic("logTopic"));
        consumer.setMessageListener(this);
    }

    public static void main(String[] args) throws Exception {
        new Log4jJMSAppenderExample();
        System.in.read();
    }

    public void onMessage(Message message) {
        try {
            // receive log event in your consumer
            LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message).getObject();
            System.out.println("Received log [" + event.getLevel() + "]: " + event.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

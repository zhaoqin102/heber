package com.muchu.heber.logger.test.rabbit;

import com.rabbitmq.client.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 梁海鹏
 * @createTime 17-1-2 下午6:26
 */
public class PublishTest {

    private ConnectionFactory connectionFactory;

    @Before
    public void setUp() {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
    }

//    @Test
    public void publish() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs", "fanout");
        channel.queueBind("hello", "logs", "");
        channel.basicPublish("logs", "", null, "publish".getBytes());
        channel.close();
        connection.close();
    }

    public static void main(String[] argv) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs", "fanout");
        channel.queueBind("hello", "logs", "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume("hello", true, consumer);
    }
}

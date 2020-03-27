package com.zlx.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * topic 模式
 */
public class Send {
    private static final String EXCHANGE_NAME = "ex1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String name = "商品";
        String routingKey = "goods.insert";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,name.getBytes());

        System.out.println("fa送的消息"+name);
        channel.close();
        connection.close();
    }
}

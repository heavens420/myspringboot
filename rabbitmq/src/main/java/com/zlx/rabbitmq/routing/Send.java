package com.zlx.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.RabbitmqApplication;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANGE_NAME = "exchagne2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnection.getConnection();

        Channel channel = connection.createChannel();

        //routing 模式  type = direct
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = "hello";
        String routingKey = "key2"; //交换机根据 routingKey 转发给有key1标签的队列
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,message.getBytes());

        channel.close();
        connection.close();
    }
}

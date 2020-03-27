package com.zlx.rabbitmq.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布订阅模式（publish subscribe）
 * 消息通过交换机 发送到 消费者自己的队列
 * 每个消费者都有一个自己的队列
 */
public class Send {

    private static final String EXCHANGE_NAME = "exchange1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnection.getConnection();

        Channel channel = connection.createChannel();

        //声明队列
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //发送消息
        String message = "publish subscribe ";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());

        //关闭
        channel.close();
        connection.close();

    }
}

package com.zlx.rabbitmq.simplequeue;

import com.rabbitmq.client.*;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * simple 简单模式
 *
 * 消费者 接收消息
 */

public class Receive {

    private static final String QUEUE_NAME = "MYQUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取一个连接
        Connection connection = RabbitConnection.getConnection();

        //创建一个频道
        Channel channel = connection.createChannel();

        //声明队列 不声明亦可
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //定义消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            //获取消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("接受到的消息："+msg);
            }
        };

        //监听队列  不关闭 用于实时接收消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

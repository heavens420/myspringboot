package com.zlx.rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * simple 简单模式
 *
 * 生产者 发送消息
 */

public class Send {

    private static final String   QUEUE_NAME = "MYQUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取一个连接
        Connection connection = RabbitConnection.getConnection();

        //从连接中获取一个通道
        Channel channel =  connection.createChannel();

        //创建声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //要发送的消息
        String msg = "the first rabbitmq message";

        //发送消息
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.println("发送的消息："+msg);

        //关闭
        channel.close();
        connection.close();
    }
}

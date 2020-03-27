package com.zlx.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * workQueue
 *
 * 连续发送多条消息
 */
public class Send {

    private static final String QUEUE_NAME = "WORK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接
        Connection connection = RabbitConnection.getConnection();

        //获取channel
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //发送队列
        for (int i = 0; i < 50; i++) {
            String s = "wq"+i;
            channel.basicPublish("",QUEUE_NAME,null,s.getBytes());
            Thread.sleep(20*i);
        }

        //关闭
        channel.close();
        connection.close();
    }
}

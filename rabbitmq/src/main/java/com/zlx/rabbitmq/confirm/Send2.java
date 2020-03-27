package com.zlx.rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;

/**
 * 批量发送
 */
public class Send2 {
    private static final String QUEUE_NAME = "qq";

    public static void main(String[] args) throws Exception {
        String message = "batch confirm message";

        Connection connection = RabbitConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //开启事务 事务和confirm模式不可同时开启
//            channel.txSelect();
        //开启confirm模式
        channel.confirmSelect();

        for (int i = 0; i < 20; i++) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }

        if (!channel.waitForConfirms()) {
            System.out.println("send failed");
        }else {
            System.out.println("send success");
        }
        channel.close();
        connection.close();
    }
}

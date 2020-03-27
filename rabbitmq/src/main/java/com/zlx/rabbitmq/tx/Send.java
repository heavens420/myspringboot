package com.zlx.rabbitmq.tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String QUEUE_NAME = "qu";

    public static void main(String[] args) throws Exception {


        String message = "tx message";

        Connection connection = RabbitConnection.getConnection();
        Channel channel = connection.createChannel();

        try {


            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //开启事务
            channel.txSelect();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            //设置异常
            int s = 1/0;
            System.out.println("fa送："+message);
            channel.txCommit();
        } catch (Exception  e) {
            channel.txRollback();
            System.out.println("tx 回滚");
        }finally {
            channel.close();
            connection.close();
        }


    }
}

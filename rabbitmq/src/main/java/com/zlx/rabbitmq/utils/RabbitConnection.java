package com.zlx.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConnection {

    /**
     * 获取rabbitmq的连接
     * @return
     */

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //设置服务地址
        connectionFactory.setHost("heavens.tk");

        //AMQP 5672
        connectionFactory.setPort(5672);

        //vhost 虚拟路径 （数据库）
        connectionFactory.setVirtualHost("/myrabbit");

        //账户密码
        connectionFactory.setUsername("heavens");
        connectionFactory.setPassword("heavens420");

        return connectionFactory.newConnection();
    }
}

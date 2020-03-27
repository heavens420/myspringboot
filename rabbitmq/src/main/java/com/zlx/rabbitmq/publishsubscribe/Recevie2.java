package com.zlx.rabbitmq.publishsubscribe;

import com.rabbitmq.client.*;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recevie2 {

    private static final String QUEUE_NAME = "publilsh subscribe model2";
    private static final String EXCHANGE_NAME = "exchange1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnection.getConnection();

        Channel channel = connection.createChannel();

        //声明队列用于存储消息 交换机 没有存储能力
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //绑定队列 到 交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        channel.basicQos(1);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, "utf-8");
                System.out.println(s);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("消费完成");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        // 自动应答
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}

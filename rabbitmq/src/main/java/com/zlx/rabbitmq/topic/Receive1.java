package com.zlx.rabbitmq.topic;

import com.rabbitmq.client.*;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive1 {
    private static final String QUEUE_NAME = "QU1";
    private static final String EXCHANGE_NAME = "ex1";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitConnection.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);

        //给队列加 标签key1  交换机会根据标签 决定消息转发给谁
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"goods.add");

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

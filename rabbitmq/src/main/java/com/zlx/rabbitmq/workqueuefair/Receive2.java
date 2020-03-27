package com.zlx.rabbitmq.workqueuefair;

import com.rabbitmq.client.*;
import com.zlx.rabbitmq.utils.RabbitConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive2 {
    private static final String QUEUE_NAME = "WORK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = RabbitConnection.getConnection();

        //创建频道
        Channel channel = connection.createChannel();

        channel.basicQos(1);//保证一次只发送一条消息

        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //消费者1
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, "utf-8");
                System.out.println("消费者2：" + s);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("消费者 2 完成消费");
                    //消息消费完 通知生产者
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };

        //监听队列
        boolean autoAck = false; //自动ack
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}

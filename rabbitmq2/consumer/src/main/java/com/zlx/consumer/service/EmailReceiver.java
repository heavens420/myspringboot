package com.zlx.consumer.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailReceiver {

    @RabbitListener(queues = "EmailQueue") //与config配置中的队列名称相同
    public void Receive(String msg){
        System.out.println("接收到的消息："+msg);
    }

    //注解配置绑定交换机和队列 设置交换机类型 指定routingkey
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order.fanout.queue",autoDelete = "true"),
                    exchange = @Exchange(value = "order.fanout.ex",type = ExchangeTypes.FANOUT),
                    key = "" /*routingKey*/ ))
    public void RecOrder(String message){
        System.out.println("消费消息："+message);
    }
}

package com.zlx.consumer2.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailReceiver {

    //注解配置绑定交换机和队列 设置交换机类型 指定routingkey
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "order.direct.log.queue",autoDelete = "true"),
                    exchange = @Exchange(value = "order.direct.ex",type = ExchangeTypes.DIRECT),
                    key = "log" /*routingKey*/ ))
    public void RecOrder(String message){
        System.out.println("Receive Log 消息："+message);
    }
}

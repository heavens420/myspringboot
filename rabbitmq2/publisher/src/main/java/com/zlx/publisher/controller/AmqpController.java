package com.zlx.publisher.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
public class AmqpController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    //direct模式

    @RequestMapping("1")
    public String sendEmail(@RequestParam Map<String,Object> map){
        String msg = map.get("msg").toString();
        rabbitTemplate.convertAndSend("EmailExchange","EmailRouting",msg);
        return "OK";
    }


    //fanout 模式 无routingkey  写了routingkey 也会被默认忽略

    @RequestMapping("2")
    public String SendOrder(){

        //定义交换机
        String exchangeName = "order.fanout.ex";
        //定义queue
        String routingKey = "";

        String orderId = UUID.randomUUID().toString();
        String message = "你的订单号："+orderId+"，日期是："+new Date();

        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
        System.out.println("Send over :"+message);
        return "Send Over";
    }

    //direct 模式 有routingkey


    @RequestMapping("3")
    public String DirectSend(){
        //定义交换机
        String exchangeName = "order.direct.ex";

        //定义多个routingkey
        String routingKey1 = "log";
        String routingKey2 = "add";
        String routingKey3 = "delete";

        String message = "Log:"+UUID.randomUUID().toString()+new Date();
        String message2 = routingKey2 + UUID.randomUUID().toString()+new Date();

        //发送给 指定的routingKey

        rabbitTemplate.convertAndSend(exchangeName,routingKey1,message);
        rabbitTemplate.convertAndSend(exchangeName,routingKey2,message2);
        System.out.println(routingKey1+" yi send:"+message);
        System.out.println(routingKey2+" yi send:"+message);
        return "Send over";
    }
}

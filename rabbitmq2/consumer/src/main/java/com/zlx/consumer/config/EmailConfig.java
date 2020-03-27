package com.zlx.consumer.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    //交换机
    @Bean
    DirectExchange EmailExchange(){
        return new DirectExchange("EmailExchange");
    }

    //队列
    @Bean
    Queue EmailQueue(){
        return new Queue("EmailQueue");
    }

    //绑定队列 交换机
    Binding BindEmail(){
        return BindingBuilder.bind(EmailQueue()).to(EmailExchange()).with("EmailRouting");
    }
}

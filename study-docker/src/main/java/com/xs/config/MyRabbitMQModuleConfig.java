package com.xs.config;

import com.xs.constant.RabbitMQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MyRabbitMQModuleConfig
 * Package: com.xs.config
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/22 15:10
 * @Version 1.0
 */

@Configuration
public class MyRabbitMQModuleConfig {

    // 订单队列
    @Bean
    public Exchange orderExchange() {
        return new DirectExchange(RabbitMQConstant.ORDER_EXCHANGE, true, false);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(RabbitMQConstant.ORDER_QUEUE, true);
    }

    @Bean
    public Binding orderBinding() {
        return new Binding(RabbitMQConstant.ORDER_QUEUE,
                Binding.DestinationType.QUEUE,
                RabbitMQConstant.ORDER_EXCHANGE,
                RabbitMQConstant.ORDER_ROUTER_KEY,
                null);
    }

}

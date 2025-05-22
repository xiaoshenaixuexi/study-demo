package com.xs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 高伟
 * @create 2024-12-09 15:07
 */

@Configuration
public class MessageConverterConfig {

    /**
     * 保证 rabbitmq 发送和接收对象传输的是 json 格式的数据
     * @return
     */
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }


}

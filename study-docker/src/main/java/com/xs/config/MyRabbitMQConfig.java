package com.xs.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 高伟
 * @create 2024-11-19 17:48
 */

@Configuration
@Slf4j
public class MyRabbitMQConfig {



    /**
     * 解决消息丢失问题：
     *      发送消息时 try-catch 包围 预防网络断开或连接断开导致消息丢失
     *      定制 RabbitTemplate
     *      生产者 -> Broker(exchange -> routerKey -> queue) -> 消费者
     *      setConfirmCallback 当未到达 exchange 时 回调函数  ack 为 false   只要到达 exchange ack 就为 true
     *      setReturnCallback 当未到达 queue 时 回调函数
     *      queue -> 消费者 通过消息的手动确认来保证 消息不丢失
     * 解决消息乱序：TODO
     * 解决消息重复消费：分布式锁
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
		//设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用返回调函数
        rabbitTemplate.setMandatory(true);
        /**
         * 消息的可靠性投递 投递消息给交换机执行的回调函数  只要交换机收到就回调函数
         * correlationData：相关配置信息
         * ack： exchange是否收到消息的确认信号
         * cause：原因
         */
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                // 如果失败
                if(!ack) {
                    // TODO 写消息
                    log.error("confirm...===>相关数据:["+ JSONUtil.toJsonStr(correlationData) +"]===>失败原因["+cause+"]");
                }
            }
        });

        /**
         * Exchange路由到Queue失败会执行ReturnCallback
         * 1.开启回退模式
         * 2.给rabbitTemplate注入ReturnCallback
         * 3.设置Exchange处理消息的模式
         *      1.如果消息没有路由到Queue，则丢弃消息(默认)；
         *      2.如果消息没有路由到Queue，则消息返回给发送方ReturnCallback
         */
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                Object clazzName = message.getMessageProperties().getHeaders().get("__TypeId__");
                log.error("消息类型：{}", clazzName);
                String content = new String(message.getBody());
                try {
                    Object bean = JSONUtil.toBean(content, Class.forName((String) clazzName));
                    log.error("消息体：{}", JSONUtil.toJsonStr(bean));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                log.error("Fail...===>消息:["+JSONUtil.toJsonStr(message)+"]===>回应码:["+replyCode+"]===>回应消息:["+replyText+"]===>交换机:["+exchange+"]===>路由键:["+routingKey+"]");
            }
        });

        // 生产者发送消息JSON序列化
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}

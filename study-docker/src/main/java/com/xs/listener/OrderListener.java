package com.xs.listener;

import com.rabbitmq.client.Channel;
import com.xs.constant.RabbitMQConstant;
import com.xs.entity.Order;
import com.xs.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

/**
 * ClassName: OrderListener
 * Package: com.xs.listener
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/22 15:10
 * @Version 1.0
 */


@Service
@Slf4j
public class OrderListener {

    @Resource
    private OrderMapper orderMapper;

    @RabbitListener(queues = {RabbitMQConstant.ORDER_QUEUE})
    public void listener(Message message, Channel channel, Order order) {
        long tag = message.getMessageProperties().getDeliveryTag();
        try {
            orderMapper.insert(order);
            // TODO 生成订单+生成流水
        } catch (Exception e) {
            log.error("创建订单报错：", e);
        } finally {
            try {
                // 消息确认
                channel.basicAck(tag, false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

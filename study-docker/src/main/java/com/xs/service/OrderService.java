package com.xs.service;

import com.xs.common.Result;
import com.xs.constant.RabbitMQConstant;
import com.xs.entity.dto.OrderDTO;
import com.xs.entity.Order;
import com.xs.enums.OrderStatusEnum;
import com.xs.mapper.OrderMapper;
import com.xs.mapper.ProductMapper;
import com.xs.util.OrderUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClassName: OrderService
 * Package: com.xs.service
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:20
 * @Version 1.0
 */

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public Result create(OrderDTO orderDTO) {
        // 1.扣减库存
        int success = productMapper.deductStock(orderDTO.getProductId(), orderDTO.getQuantity());
        if(success <= 0) {
            return new Result("500", "库存不足");
        }

        // 2.生成订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setOrderCode(OrderUtils.generateOrderCode());
        order.setOrderStatus(OrderStatusEnum.PACKAGED.getOrderStatus());
        rabbitTemplate.convertAndSend(RabbitMQConstant.ORDER_EXCHANGE, RabbitMQConstant.ORDER_ROUTER_KEY, order);
        return Result.success("创建成功！");
    }
}

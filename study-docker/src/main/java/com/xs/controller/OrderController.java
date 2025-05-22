package com.xs.controller;

import com.xs.common.Result;
import com.xs.entity.dto.OrderDTO;
import com.xs.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: OrderController
 * Package: com.xs.controller
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:17
 * @Version 1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public Result create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }


}

package com.xs.entity;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: Order
 * Package: com.xs.entity
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:20
 * @Version 1.0
 */

@Data
public class Order {

    private Long id;

    /**
     *
     */
    private String orderCode;

    /**
     *
     */
    private String customer;

    /**
     *
     */
    private Long productId;

    /**
     *
     */
    private String productName;

    /**
     *
     */
    private Integer quantity;

    /**
     *
     */
    private Integer orderStatus;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;

}

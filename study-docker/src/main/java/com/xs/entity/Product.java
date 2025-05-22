package com.xs.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName: Product
 * Package: com.xs.entity
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/13 09:57
 * @Version 1.0
 */

@Data
public class Product {

    private Long id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer quantity;

    /**
     *
     */
    private BigDecimal price;

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

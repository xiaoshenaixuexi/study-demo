package com.xs.dto;

import lombok.Data;

/**
 * ClassName: OrderDTO
 * Package: com.xs.dto
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:58
 * @Version 1.0
 */

@Data
public class OrderDTO {

    private String customer;
    private Long productId;
    private String productName;
    private Integer quantity;

}

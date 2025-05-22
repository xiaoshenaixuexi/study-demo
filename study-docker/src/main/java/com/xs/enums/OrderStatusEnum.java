package com.xs.enums;

/**
 * ClassName: OrderStatusEnum
 * Package: com.xs.enums
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 18:43
 * @Version 1.0
 */
public enum OrderStatusEnum {
    PACKAGED(0),
    SHIPPED(1),
    CANCELED(2),
    ;

    private Integer orderStatus;

    OrderStatusEnum(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }
}

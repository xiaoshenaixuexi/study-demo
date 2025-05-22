package com.xs.mapper;

import com.xs.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: OrderMapper
 * Package: com.xs.mapper
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:46
 * @Version 1.0
 */

@Mapper
public interface OrderMapper {

    int insert(@Param("order") Order order);

}

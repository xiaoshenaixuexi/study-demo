package com.xs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: ProductMapper
 * Package: com.xs.mapper
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/13 09:58
 * @Version 1.0
 */

@Mapper
public interface ProductMapper {

    /**
     * 扣减库存
     * @return
     */
    int deductStock(@Param("productId") Long productId, @Param("quantity") Integer quantity);

}

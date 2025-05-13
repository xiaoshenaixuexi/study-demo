package com.xs.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName: OrderUtils
 * Package: com.xs.util
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 18:08
 * @Version 1.0
 */
public class OrderUtils {



    /**
     * 生成订单号，保证并发情况下不会重复
     * @return
     */
    public static String generateOrderCode() {
        return "O" + SnowFlake.nextId();
    }


}

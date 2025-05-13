package com.xs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: OrderDemoApplication
 * Package: com.xs
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:05
 * @Version 1.0
 */

@MapperScan("com.xs.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class OrderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDemoApplication.class, args);
    }

}

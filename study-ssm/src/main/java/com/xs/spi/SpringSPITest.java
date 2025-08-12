package com.xs.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * ClassName: SpringSPITest
 * Package: com.xs.spi
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/12 16:47
 * @Version 1.0
 */
public class SpringSPITest {

    public static void main(String[] args) {
        List<DataBaseSPI> dataBaseSPIS = SpringFactoriesLoader.loadFactories(DataBaseSPI.class, Thread.currentThread().getContextClassLoader());
        dataBaseSPIS.forEach(item -> item.getConnection());
    }

}

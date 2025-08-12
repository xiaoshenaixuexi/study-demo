package com.xs.spi;

/**
 * ClassName: MySqlDataBase
 * Package: com.xs.spi
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/12 16:45
 * @Version 1.0
 */
public class MySqlDataBase implements DataBaseSPI{
    @Override
    public void getConnection() {
        System.out.println("this mysql database");
    }
}

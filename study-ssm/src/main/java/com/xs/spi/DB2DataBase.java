package com.xs.spi;

/**
 * ClassName: DB2DataBase
 * Package: com.xs.spi
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/12 16:44
 * @Version 1.0
 */
public class DB2DataBase implements DataBaseSPI{
    @Override
    public void getConnection() {
        System.out.println("this database is db2");
    }
}

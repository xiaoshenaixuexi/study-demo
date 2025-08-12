package com.xs.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* ClassName: Main
* Package: com.xs
* Description: 多线程并发访问 SimpleDateFormat 出现并发安全问题。i每次+1,1000次循环，线程安全的情况下，不应该出现生成的日期相同的情况
* @Author 高伟
* @Create 2025/8/7 16:06
* @Version 1.0
*/
public class Demo1 {

    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            EXECUTOR.execute(() ->{
                System.out.println(SIMPLE_DATE_FORMAT.format(new Date(finalI * 1000)));
            });
        }
    }

}

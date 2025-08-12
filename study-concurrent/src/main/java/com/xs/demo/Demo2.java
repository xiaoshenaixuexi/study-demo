package com.xs.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: Demo2
 * Package: com.xs.demo
 * Description:保证并发安全
 *
 * @Author 高伟
 * @Create 2025/8/7 16:20
 * @Version 1.0
 */
public class Demo2 {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10, 1000, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            int finalI = i;
            EXECUTOR.execute(() -> {
                ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
                SimpleDateFormat simpleDateFormat = threadLocal.get();
                if(simpleDateFormat == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                    simpleDateFormat = threadLocal.get();
                }
                System.out.println(simpleDateFormat.format(new Date(finalI * 1000)));
            });
        }

    }

}

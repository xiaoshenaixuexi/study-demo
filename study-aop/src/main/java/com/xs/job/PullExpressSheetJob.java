package com.xs.job;

import com.xs.annotation.EnableFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ClassName: PullExpressSheetJob
 * Package: com.xs.job
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/7 11:28
 * @Version 1.0
 */

@Component
public class PullExpressSheetJob {

    /**
     * 模拟两个定时任务
     */
    @EnableFeature(value = "shipout")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void pushOrder() {
        System.out.println("============开始执行定时任务============");
        System.out.println("推算订单");
        System.out.println("============终止执行定时任务============");
    }


    @EnableFeature(value = "koda")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void pullExpressSheet() {
        System.out.println("============开始执行定时任务============");
        System.out.println("拉取面单");
        System.out.println("============终止执行定时任务============");
    }

}

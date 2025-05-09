package com.xs.controller;

import com.xs.annotation.EnableFeature;
import com.xs.annotation.FrequencyLimit;
import com.xs.common.Result;
import com.xs.properties.SwitchProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: HelloController
 * Package: com.xs.controller
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/7 11:24
 * @Version 1.0
 */

@RestController
public class HelloController {

    @Resource
    private SwitchProperties switchProperties;

    /**
     * 注解含义：在1秒内调用超过5次，则提示：超过频次后的提示信息！
     * @return
     */
    @FrequencyLimit(value = 5, time = 1, timeUnit = TimeUnit.SECONDS, message = "超过频次后的提示信息！")
    @GetMapping("/test")
    public Result<String> test() throws InterruptedException {
        Thread.sleep(1000 * 5);
        return Result.success("Hello World!");
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


}

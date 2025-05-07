package com.xs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.xs.controller
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/6 10:05
 * @Version 1.0
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/cpuLoadTest")
    public String cpuLoadTest() {
        // 死循环
        if(true) {
            while (true) {
            }
        }
        return "cpu";
    }
}

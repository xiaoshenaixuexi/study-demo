package com.xs.controller;

import com.xs.annotation.EnableFeature;
import com.xs.properties.SwitchProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @GetMapping("/switch")
    public String switchTest() {
        return "test1:" + switchProperties.getTest1() + ",test2:" + switchProperties.getTest2() + ",test3:" + switchProperties.getTest3();
    }

    @EnableFeature(value = "test1")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


}

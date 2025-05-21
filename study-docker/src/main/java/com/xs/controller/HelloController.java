package com.xs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.xs.controller
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/21 18:06
 * @Version 1.0
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}

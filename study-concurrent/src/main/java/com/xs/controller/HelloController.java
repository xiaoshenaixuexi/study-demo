package com.xs.controller;

import com.xs.annotation.Login;
import com.xs.pojo.dto.UserDto;
import com.xs.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: HelloController
 * Package: com.xs.controller
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 14:39
 * @Version 1.0
 */

@RestController
public class HelloController {

    @Resource
    private LoginService loginService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Login
    @GetMapping("/user")
    public UserDto getUser() {
        return loginService.getUser();
    }

}

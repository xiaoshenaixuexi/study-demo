package com.xs.service;

import com.xs.pojo.dto.UserDto;
import com.xs.util.LoginContext;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginService
 * Package: com.xs.service
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/8 17:38
 * @Version 1.0
 */

@Service
public class LoginService {



    public UserDto getUser() {
        return LoginContext.getUserData();
    }

}

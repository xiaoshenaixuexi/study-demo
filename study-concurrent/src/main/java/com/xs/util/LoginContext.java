package com.xs.util;

import com.xs.pojo.dto.RequestData;
import com.xs.pojo.dto.UserDto;

/**
 * ClassName: LoginContext
 * Package: com.xs.util
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 18:11
 * @Version 1.0
 */
public class LoginContext {

    private final static ThreadLocal<UserDto> USER_CONTEXT = new ThreadLocal<>();
    private final static ThreadLocal<RequestData> USER_REQUEST = new ThreadLocal<>();

    /**
     * 设置用户上下文
     * @param userDto 用户基础信息
     */
    public static void setUserData(UserDto userDto) {
        USER_CONTEXT.set(userDto);
    }

    /**
     * 获取用户信息
     * @return 用户信息
     */
    public static UserDto getUserData() {
        return USER_CONTEXT.get();
    }

    /**
     * 删除本次用户信息
     */
    public static void removeUserData() {
        USER_CONTEXT.remove();
    }


}

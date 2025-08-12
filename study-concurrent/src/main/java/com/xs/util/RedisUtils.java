package com.xs.util;

import com.xs.pojo.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * ClassName: RedisUtils
 * Package: com.xs.util
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 18:19
 * @Version 1.0
 */

public class RedisUtils {

    public static UserDto getUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1l);
        userDto.setUsername("小明");
        userDto.setPassword("111222");
        return userDto;
    }

}

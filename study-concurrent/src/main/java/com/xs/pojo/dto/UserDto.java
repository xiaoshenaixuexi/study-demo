package com.xs.pojo.dto;

import com.xs.pojo.User;
import lombok.Data;

/**
 * ClassName: UserDto
 * Package: com.xs.pojo.dto
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 18:10
 * @Version 1.0
 */

@Data
public class UserDto {

    private Long id;
    private String username;// 用户名
    private String password;// 密码

}

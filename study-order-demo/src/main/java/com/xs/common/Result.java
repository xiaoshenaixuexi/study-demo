package com.xs.common;

import lombok.Data;

/**
 * ClassName: Result
 * Package: com.xs.common
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:21
 * @Version 1.0
 */

@Data
public class Result<T> {

    private String code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

}

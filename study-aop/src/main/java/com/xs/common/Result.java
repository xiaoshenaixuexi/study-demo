package com.xs.common;

import lombok.Data;

/**
 * ClassName: Result
 * Package: com.xs.common
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/9 11:13
 * @Version 1.0
 */

@Data
public class Result<T> {

    private String code;// 状态码
    private String message;// 返回信息
    private T data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result("200", "success");
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>("200", "success", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>("200", message, data);
    }

    public static Result error(String code, String message) {
        return new Result(code, message);
    }

}

package com.xs.exception;


/**
 * 自定义异常类
 * @author 高伟
 * @create 2024-09-02 16:06
 */
public class CustomerException extends RuntimeException {

    private String message;

    public CustomerException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

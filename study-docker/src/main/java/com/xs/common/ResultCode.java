package com.xs.common;

/**
 * ClassName: ResultCode
 * Package: com.xs.common
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/12 17:22
 * @Version 1.0
 */
public enum ResultCode {

    SUCCESS("200", "操作成功"),
    FAIL("500", "操作失败"),
    ;

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

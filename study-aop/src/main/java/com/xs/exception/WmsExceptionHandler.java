package com.xs.exception;


import com.xs.common.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常捕捉处理
 *
 * @author wangtianlong
 */

@ControllerAdvice
@Component
public class WmsExceptionHandler {

    /**
     * 自定义异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(CustomerException.class)
    public Result businessExceptionHandler(CustomerException ex) {
        return Result.error("500", ex.getMessage());
    }

}

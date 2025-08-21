package com.xs.base;

import com.xs.common.Result;

/**
 * ClassName: BaseController
 * Package: com.xs.base
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/21 16:21
 * @Version 1.0
 */

public class BaseController {

    protected <T> Result<T> convertSuccessResult(T data) {
        Result<T> result = Result.success();
        result.setData(data);
        return result;
    }

}

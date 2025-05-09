package com.xs.annotation;

import com.xs.common.Result;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: FrequencyLimit
 * Package: com.xs.annotation
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/9 11:10
 * @Version 1.0
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FrequencyLimit {

    long value() default 1;// 次数
    long time() default 1;// 多长时间
    TimeUnit timeUnit() default TimeUnit.SECONDS;// 时间单位
    String message() default "操作过于频繁，请稍后重试!";// 提示语

}

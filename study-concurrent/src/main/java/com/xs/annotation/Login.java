package com.xs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Login
 * Package: com.xs.annotation
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 18:21
 * @Version 1.0
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
}

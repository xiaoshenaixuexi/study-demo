package com.xs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: EnableFeature
 * Package: com.xs.annotations
 * Description:
 *
 * @Author 高伟
 * @Create 2025/5/7 11:33
 * @Version 1.0
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableFeature {

    boolean enable() default true;
    String value() default "";

}

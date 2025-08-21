package com.xs.aspect;

import cn.hutool.cache.Cache;
import cn.hutool.cache.impl.TimedCache;
import com.xs.exception.CustomerException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * ClassName: RepeatSubmitAspect
 * Package: com.xs.aspect
 * Description:防重复调用切面
 *
 * @Author 高伟
 * @Create 2025/8/21 16:15
 * @Version 1.0
 */

@Aspect
@Component
public class RepeatSubmitAspect {

    private static final Object PRESENT = new Object();

    private Cache<String, Object> cache = new TimedCache<>(20000);

    @Around("execution(* com.xs.controller..*.*(..))")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args.length < 1) {
            return proceedingJoinPoint.proceed();
        }

        for (Object parameter : args) {
            Field field = ReflectionUtils.findField(parameter.getClass(), "uuid");
            if (field == null) {
                break;
            }
            field.setAccessible(true);
            String uuid = (String) ReflectionUtils.getField(field, parameter);
            if (uuid == null) {
                break;
            }

            synchronized (this) {
                if (cache.get(uuid) != null) {
                    throw new CustomerException("重复提交");
                }
                cache.put(uuid, PRESENT);
            }
        }
        return proceedingJoinPoint.proceed();
    }

}

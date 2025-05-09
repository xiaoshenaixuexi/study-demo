package com.xs.aspect;

import com.xs.annotation.EnableFeature;
import com.xs.properties.SwitchProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * ClassName: EnableFeatureAspect
 * Package: com.xs.aspect
 * Description:开关控制切面
 *
 * @Author 高伟
 * @Create 2025/5/7 11:36
 * @Version 1.0
 */

@Aspect
@Component
public class EnableFeatureAspect {

    @Resource
    private SwitchProperties switchProperties;

    @Pointcut("@annotation(com.xs.annotation.EnableFeature)")
    public void pointcut() {}

    /**
     * 基于 enable 属性实现
     * @param joinPoint
     * @return
     */
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        if(signature instanceof MethodSignature) {
//            Method method = ((MethodSignature) signature).getMethod();
//            EnableFeature annotation = method.getAnnotation(EnableFeature.class);
//            if(annotation != null && annotation.enable()) {
//                try {
//                    return joinPoint.proceed();
//                } catch (Throwable e) {
//                    throw new RuntimeException(e);
//                }
//            } else {
//                return "Feature disabled";
//            }
//        } else {
//            return "Feature disabled";
//        }
//    }

    /**
     * 基于 value 属性实现
     * @param joinPoint
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if(signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            EnableFeature annotation = method.getAnnotation(EnableFeature.class);
            if(annotation != null && (Boolean) switchProperties.get(annotation.value())) {
                try {
                    return joinPoint.proceed();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}

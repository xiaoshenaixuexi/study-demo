package com.xs.aspect;

import cn.hutool.core.codec.Base64;
import com.xs.annotation.EnableFeature;
import com.xs.annotation.FrequencyLimit;
import com.xs.exception.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: FrequencyLimitAspect
 * Package: com.xs.aspect
 * Description:访问频次限制切面
 *  限制：只支持对方法标识注解的访问频次限制
 * @Author 高伟
 * @Create 2025/5/9 11:33
 * @Version 1.0
 */

@Aspect
@Component
@Slf4j
public class FrequencyLimitAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.xs.annotation.FrequencyLimit)")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        // 获取调用方 IP
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        String ipAddr = httpServletRequest.getRemoteAddr();


        Signature signature = joinPoint.getSignature();
        if(signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            FrequencyLimit annotation = method.getAnnotation(FrequencyLimit.class);
            // 获取方法名
            String methodFullName = method.getDeclaringClass().getName() + method.getName();

            // 默认处理策略 TODO 可扩展其他处理策略
            defaultHandler(annotation, ipAddr, methodFullName);
        }

    }

    /**
     * 默认处理方式：超过限制频次就返回系统繁忙信息
     * 思路：
     *  每次调用 Redis 的 incr 方法，如果返回值为 1 表示单位时间内第一次调用。超过 value，证明在过期时间内已经超过了访问频次
     * @return
     */
    private void defaultHandler(FrequencyLimit annotation, String ipAddr, String methodFullName) {
        // 获取注解参数  time(timeUnit) 时间间隔内限制调用 value 次。失败抛异常，异常会被全局处理
        long value = annotation.value();
        long time = annotation.time();
        TimeUnit timeUnit = annotation.timeUnit();

        // 构建 Redis key
        String redisKey = "frequencyLimit:" + methodFullName + ":" + Base64.encode(ipAddr);
        Long count = stringRedisTemplate.opsForValue().increment(redisKey);
        if(count == 1) {
            // 第一次调用，设置访问限制时间
            stringRedisTemplate.expire(redisKey, time, timeUnit);
        }
        // time 时间间隔内n次调用，超过限制频次就返回系统繁忙信息
        if(count > value) {
            String message = annotation.message();
            throw new CustomerException(message);
        }
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("耗时：{}毫秒", end - start);
        return obj;
    }

}

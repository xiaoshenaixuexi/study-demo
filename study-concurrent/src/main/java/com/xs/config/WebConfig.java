package com.xs.config;

import com.xs.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebConfig
 * Package: com.xs.config
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/8 17:40
 * @Version 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**");// 拦截所有路径
//                .excludePathPatterns()// 排除某些路径
    }
}

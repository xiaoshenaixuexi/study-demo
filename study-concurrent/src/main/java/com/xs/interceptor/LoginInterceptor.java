package com.xs.interceptor;

import com.xs.annotation.Login;
import com.xs.pojo.dto.UserDto;
import com.xs.util.LoginContext;
import com.xs.util.RedisUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * ClassName: LoginInterceptor
 * Package: com.xs.interceptor
 * Description:
 *
 * @Author 高伟
 * @Create 2025/8/7 18:03
 * @Version 1.0
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 模拟获取用户信息
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if(method.isAnnotationPresent(Login.class)) {
                UserDto userDto = RedisUtils.getUserDto();
                if(userDto == null) {
                    // 模拟数据库访问
                    userDto = new UserDto();
                    userDto.setId(1l);
                    userDto.setUsername("小明");
                    userDto.setPassword("111222");
                }
                LoginContext.setUserData(userDto);
                return true;
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginContext.removeUserData();
    }
}

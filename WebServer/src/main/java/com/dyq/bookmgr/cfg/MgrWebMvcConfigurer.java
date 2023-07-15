package com.dyq.bookmgr.cfg;

import com.dyq.bookmgr.interceptor.LoginPreInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dtdyq
 * @create 2022-03-21 20:17
 **/
@Component
public class MgrWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginPreInterceptor loginPreInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginPreInterceptor)
            .addPathPatterns("/**").excludePathPatterns("/login")
            .excludePathPatterns("/login.html").excludePathPatterns("/register");
    }
}

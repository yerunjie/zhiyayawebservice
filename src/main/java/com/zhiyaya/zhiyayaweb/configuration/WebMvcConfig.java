package com.zhiyaya.zhiyayaweb.configuration;

import com.zhiyaya.zhiyayaweb.interceptor.AuthenticationInterceptor;
import com.zhiyaya.zhiyayaweb.interceptor.DBTimesInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authorizationInterceptor;

    @Autowired
    private DBTimesInterceptor dbTimesInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
        //registry.addInterceptor(dbTimesInterceptor);
    }
}

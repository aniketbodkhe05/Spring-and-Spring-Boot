package com.filtersdemo.filtersDemo.config;

import com.filtersdemo.filtersDemo.Interceptors.LoggingInterceptor;
import jakarta.servlet.http.WebConnection;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;

    public WebConfig(LoggingInterceptor interceptor){
        this.loggingInterceptor=interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingInterceptor);


    }
}

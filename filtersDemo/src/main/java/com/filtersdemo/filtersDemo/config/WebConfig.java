package com.filtersdemo.filtersDemo.config;

import com.filtersdemo.filtersDemo.Interceptors.AuthenticationInterceptor;
import com.filtersdemo.filtersDemo.Interceptors.LoggingInterceptor;
import jakarta.servlet.http.WebConnection;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;

    public WebConfig(LoggingInterceptor interceptor,AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptor=interceptor;
        this.authenticationInterceptor=authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/admin/*")
                .order(1);

        registry.addInterceptor(loggingInterceptor);


    }
}

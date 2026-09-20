package com.filtersdemo.filtersDemo.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){
        String apikey = request.getHeader("x-user-role");

        if(apikey !=null && !apikey.equals("ADMIN")){
            response.setStatus(403);

            return false;
        }
        return true;
    }
}

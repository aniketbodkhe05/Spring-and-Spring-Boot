package com.filtersdemo.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        Long starttime=System.currentTimeMillis();
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        String requestId= UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-request-id",requestId);


        System.out.println("Incoming Request"
                +httpServletRequest.getMethod()
        +" "+httpServletRequest.getRequestURI());


        chain.doFilter(request,response);

        long duration =System.currentTimeMillis()-starttime;

        System.out.println("Response status: "+httpServletResponse.getStatus());

        System.out.println("Api ResponseTime: "+duration);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

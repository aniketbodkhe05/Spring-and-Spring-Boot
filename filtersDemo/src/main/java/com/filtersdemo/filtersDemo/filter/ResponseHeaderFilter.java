package com.filtersdemo.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =(HttpServletResponse) response;
        String requestId = UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-requestId",requestId);

        chain.doFilter(request,response);
    }
}

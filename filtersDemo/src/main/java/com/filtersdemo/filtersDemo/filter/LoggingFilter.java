package com.filtersdemo.filtersDemo.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
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

        System.out.println("Request enter in logging flter");

        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

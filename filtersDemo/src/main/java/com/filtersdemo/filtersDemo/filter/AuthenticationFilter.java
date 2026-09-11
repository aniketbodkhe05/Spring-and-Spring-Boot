package com.filtersdemo.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        String token=httpServletRequest.getHeader("token");
        String apikey =httpServletRequest.getHeader("X-api-key");
        if(token==null || !token.equals("12345")){
            httpServletResponse.setStatus(401);
            return;
        }
        if(apikey==null || !apikey.equals("secret123")){
            httpServletResponse.setStatus(401);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "  \"message\": \"API key is invalid/missing\"\n" +
                            "}"
            );
            return;
        }
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

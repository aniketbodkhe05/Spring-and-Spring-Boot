package com.filtersdemo.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) request;

        HttpServletResponse httpServletResponse=(HttpServletResponse) response;

        ContentCachingResponseWrapper wrapper=new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request,wrapper);
        byte[] originalbodybite =
                wrapper.getContentAsByteArray();

        String originalBody = new String(originalbodybite);
        String modifiedBody =
                """
                        {
                        "originalResponse":%s,
                        "appName":"Student Management System
                        }
                        """.formatted(originalBody);

        wrapper.resetBuffer();

        wrapper.getWriter().write(modifiedBody);

        wrapper.copyBodyToResponse();

    }
}

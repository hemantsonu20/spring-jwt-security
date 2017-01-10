package com.github.spring.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLoggingFilter extends AbstractFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        LOG.info("request received {} {}", request.getMethod(), request.getRequestURI());
        try {
            chain.doFilter(request, response);
        }
        finally {
            LOG.info("response returned {} {} {}", request.getMethod(), request.getRequestURI(), response.getStatus());
        }
    }
}

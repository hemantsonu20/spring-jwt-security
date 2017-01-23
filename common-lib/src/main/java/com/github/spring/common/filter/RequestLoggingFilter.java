package com.github.spring.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A filter to log response code returned from the service
 * 
 * @author pratapihemant.patel
 *
 */
public class RequestLoggingFilter extends AbstractFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestLoggingFilter.class);

    private boolean isStackTraceEnabled;

    public RequestLoggingFilter(boolean isStackTraceEnabled) {

        this.isStackTraceEnabled = isStackTraceEnabled;
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            if (isStackTraceEnabled) {
                LOG.error("exception occurred", e);
            }
            throw e;

        } finally {
            LOG.info("request {} {} {}", request.getMethod(), request.getRequestURI(), response.getStatus());
        }
    }
}

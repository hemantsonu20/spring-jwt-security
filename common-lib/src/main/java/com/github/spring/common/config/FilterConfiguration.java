package com.github.spring.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.github.spring.common.filter.RequestLoggingFilter;

/**
 * Class to regsiter filter to be used
 * 
 * @author pratapihemant.patel
 *
 */
@Configuration
public class FilterConfiguration {

    @Value("${request.failure.stacktrace.log: true}")
    private boolean isStackTraceEnabled;

    @Bean
    public FilterRegistrationBean requestLoggingFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestLoggingFilter(isStackTraceEnabled));
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}

package com.github.spring.common.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean requestLoggingFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestLoggingFilter());
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registration;
    }
}

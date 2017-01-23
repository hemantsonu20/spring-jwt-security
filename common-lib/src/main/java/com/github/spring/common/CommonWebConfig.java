package com.github.spring.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.spring.common.config.FilterConfiguration;

/**
 * Some common web configuration
 * 
 * @author pratapihemant.patel
 *
 */
@Configuration
@Import({ FilterConfiguration.class })
public class CommonWebConfig {

    @Autowired
    ErrorAttributes errorAttributes;

    /**
     * Fallback bean in case of error occured in service
     * 
     * @return
     */
    @Bean
    ErrorController errorController() {

        return new ErrorController(errorAttributes, new ErrorProperties());
    }
}

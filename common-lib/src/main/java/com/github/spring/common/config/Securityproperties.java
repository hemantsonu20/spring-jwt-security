package com.github.spring.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Placeholder to import security.properties from classpath
 * 
 * @author pratapihemant.patel
 *
 */
@Configuration
@PropertySource("classpath:/security.properties")
public class Securityproperties {

}

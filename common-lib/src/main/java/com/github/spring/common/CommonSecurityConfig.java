package com.github.spring.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;

import com.github.spring.common.filter.FilterConfiguration;

/**
 * This class defines all the security configurations.
 * 
 * <ul>
 * 
 * <li>{@link EnableResourceServer &#064;EnableResourceServer} adds a security
 * filter {@link OAuth2AuthenticationProcessingFilter}
 * 
 * </li>
 * 
 * </ul>
 * 
 * @author pratapihemant.patel
 *
 */

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ Securityproperties.class, CustomWebMvcConfigurerAdapter.class, FilterConfiguration.class })
public class CommonSecurityConfig {

}

package com.github.spring.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.github.spring.common.config.CustomJwtTokenConverter;
import com.github.spring.common.config.Securityproperties;
import com.github.spring.common.filter.FilterConfiguration;

/**
 * A convenient annotation to be added on main class in any spring boot
 * application. This annotation imports the {@link CommonSecurityConfig} class
 * which defines and declares all the required configuarations.
 * 
 * 
 * @author pratapihemant.patel
 *
 */

@Target(value = { ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(value = { Securityproperties.class, CustomJwtTokenConverter.class, FilterConfiguration.class
         })
public @interface EnableSecurityFeature {

}

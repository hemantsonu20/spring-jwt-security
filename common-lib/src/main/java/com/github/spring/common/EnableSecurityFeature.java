package com.github.spring.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

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
@Import(value = { CommonSecurityConfig.class })
public @interface EnableSecurityFeature {

}

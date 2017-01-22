package com.github.spring.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.spring.common.EnableSecurityFeature;
import com.github.spring.common.token.TokenService;

@SpringBootApplication
@EnableSecurityFeature
public class ResourceServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResourceServiceApplication.class, args);
    }
    
    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }
}

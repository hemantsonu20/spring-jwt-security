package com.github.spring.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.github.spring.common.config.FilterConfiguration;
import com.github.spring.common.token.TokenService;

@SpringBootApplication
@Import(FilterConfiguration.class)
public class JwtTokenServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(JwtTokenServiceApplication.class, args);
    }
    
    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }
}

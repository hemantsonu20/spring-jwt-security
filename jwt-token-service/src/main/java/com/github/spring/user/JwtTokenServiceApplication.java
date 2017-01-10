package com.github.spring.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.spring.common.EnableSecurityFeature;

@SpringBootApplication
public class JwtTokenServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(JwtTokenServiceApplication.class, args);
    }
}

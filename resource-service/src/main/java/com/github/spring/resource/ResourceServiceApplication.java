package com.github.spring.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.spring.common.EnableSecurityFeature;

@SpringBootApplication
@EnableSecurityFeature
public class ResourceServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResourceServiceApplication.class, args);
    }
}

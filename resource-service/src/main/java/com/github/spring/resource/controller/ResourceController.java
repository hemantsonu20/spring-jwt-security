package com.github.spring.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.spring.common.token.TokenService;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    @Autowired
    TokenService service;
    
    BearerTokenExtractor extractor = new BearerTokenExtractor();
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {

        return "admin success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(@RequestHeader String authorization) {

        return "user success";
    }
}

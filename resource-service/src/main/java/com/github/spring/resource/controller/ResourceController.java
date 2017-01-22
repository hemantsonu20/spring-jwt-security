package com.github.spring.resource.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.spring.common.UserInfo;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {

        return "admin success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {

        return "user success";
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public UserInfo me() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails detail = (OAuth2AuthenticationDetails) authentication.getDetails();
        return (UserInfo) detail.getDecodedDetails();
    }
}

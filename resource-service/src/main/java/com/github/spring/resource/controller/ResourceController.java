package com.github.spring.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.spring.common.UserInfo;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    /**
     * Endpoints accessible to user with Role ADMIN
     * 
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin() {

        return "get admin success";
    }

    /**
     * Endpoints accessible to user with Role USER
     * 
     * @return
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {

        return "get user success";
    }

    /**
     * Endpoints accessible to user with any Role
     * 
     * @return
     */
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public UserInfo me() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails detail = (OAuth2AuthenticationDetails) authentication.getDetails();
        return (UserInfo) detail.getDecodedDetails();
    }
    
    /**
     * Endpoints accessible to user with authorities "ROLE_ADMIN"
     * 
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {

        return "delete user success";
    }
}

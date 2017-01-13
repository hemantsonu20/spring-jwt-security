package com.github.spring.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ResourceController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public JwtResponse admin() {

        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public JwtResponse user() {

        return null;
    }
}

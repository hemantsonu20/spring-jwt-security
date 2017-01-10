package com.github.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
@RequestMapping(value = "/api")
public class PingController {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public PingResponse ping() {

        return PingResponse.INSTANCE;
    }

    static class PingResponse {

        @JsonProperty
        static final String SERVICE = "jwt-token-service";

        @JsonProperty
        static final String HEALTH = "OK";

        public String getService() {

            return SERVICE;
        }

        public String getHealth() {

            return HEALTH;
        }

        public static final PingResponse INSTANCE = new PingResponse();
    }
}

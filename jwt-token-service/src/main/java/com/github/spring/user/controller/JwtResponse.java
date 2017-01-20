package com.github.spring.user.controller;


public class JwtResponse {

    private String jwtToken;
    
    public String getJwtToken() {

        return jwtToken;
    }

    public JwtResponse setJwtToken(String jwtToken) {

        this.jwtToken = jwtToken;
        return this;
    }
}

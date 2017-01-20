package com.github.spring.user.controller;

import javax.validation.constraints.NotNull;

public class LoginInfo {

    @NotNull
    private String username;
    
    @NotNull
    private String password;

    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}

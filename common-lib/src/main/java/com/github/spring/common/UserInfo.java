package com.github.spring.common;

public class UserInfo {

    private String id;
    private String name;
    private Role userRole;

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public Role getUserRole() {

        return userRole;
    }

    public UserInfo setId(String id) {

        this.id = id;
        return this;
    }

    public UserInfo setName(String name) {

        this.name = name;
        return this;
    }

    public UserInfo setUserRole(Role userRole) {

        this.userRole = userRole;
        return this;
    }
}

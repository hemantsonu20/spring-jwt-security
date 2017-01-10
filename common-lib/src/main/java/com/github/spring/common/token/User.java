package com.github.spring.common.token;

public class User {

    private String id;
    private String name;
    private Role role;

    public String getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public Role getRole() {

        return role;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setRole(Role role) {

        this.role = role;
    }

}

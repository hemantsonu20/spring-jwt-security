package com.github.spring.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A user info class which is used as jwt claim
 * 
 * @author pratapihemant.patel
 *
 */
public class UserInfo {

    @JsonProperty("user_name")
    private String name;
    private List<String> authorities = Collections.emptyList();

    public String getName() {

        return name;
    }

    public UserInfo setName(String name) {

        this.name = name;
        return this;
    }

    public List<String> getAuthorities() {

        return Collections.unmodifiableList(authorities);
    }

    public UserInfo setAuthorities(List<String> authorities) {

        this.authorities = new ArrayList<>(authorities);
        return this;
    }
}

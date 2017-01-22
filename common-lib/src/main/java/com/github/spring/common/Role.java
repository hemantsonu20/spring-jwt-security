package com.github.spring.common;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

    ROLE_ADMIN, ROLE_USER;

    private static Map<String, Role> map = new HashMap<>();

    static {
        for (Role r : Role.values()) {
            map.put(r.name(), r);
        }
    }

    @JsonCreator
    public static Role fromValue(String value) {

        return map.get(value);
    }
}

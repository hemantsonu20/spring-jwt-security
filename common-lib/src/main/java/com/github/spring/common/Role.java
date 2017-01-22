package com.github.spring.common;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

    SUPER_ADMIN, ADMIN, USER;

    @JsonCreator
    public static Role fromValue(String value) {

        switch (value) {

            case "SUPER_ADMIN":
                return SUPER_ADMIN;

            case "ADMIN":
                return ADMIN;

            case "USER":
                return ADMIN;

            default:
                return null;
        }
    }
}

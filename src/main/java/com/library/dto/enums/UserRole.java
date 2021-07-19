package com.library.dto.enums;

import java.util.Arrays;
import java.util.Optional;

public enum UserRole {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public static Optional<UserRole> getUserRole(String role) {
        return Arrays.stream(UserRole.values())
                .filter(value -> value.getRole().equals(role))
                .findAny();
    }

    public String getRole() {
        return role;
    }
}

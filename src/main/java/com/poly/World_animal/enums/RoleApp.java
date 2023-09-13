package com.poly.World_animal.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleApp {
    ROLE_USER("user"),ROLE_ADMIN("admin");

    private String role;
    RoleApp(String role){
        this.role = role;
    }
    @JsonValue
    public String getValue(){
        return this.role;
    }
}

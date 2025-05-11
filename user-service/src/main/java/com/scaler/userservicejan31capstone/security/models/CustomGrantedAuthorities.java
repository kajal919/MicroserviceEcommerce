package com.scaler.userservicejan31capstone.security.models;

import com.scaler.userservicejan31capstone.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;

public class CustomGrantedAuthorities implements GrantedAuthority {
    String authority;
    public CustomGrantedAuthorities(Role role) {
        this.authority = role.getValue();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}

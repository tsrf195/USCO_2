package com.test.USCO.config;

import org.springframework.security.core.GrantedAuthority;


public class UserGrantedAuthority implements GrantedAuthority {

    private final String role;

    public UserGrantedAuthority(String role){
        this.role = role;
    }

    public String getAuthority() {return this.role; }

    public String getRole(){
        return getRole();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof UserGrantedAuthority && ((UserGrantedAuthority) o).getRole().equals(this.role)){
            return true;
        }
        return false;
    }
}

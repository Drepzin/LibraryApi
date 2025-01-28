package com.livraria.api.configuration.security;

import com.livraria.api.entitys.UserLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomAuthentication implements Authentication {

    private UserLogin userLogin;

    public CustomAuthentication(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<String> role = new ArrayList<>();role.add(userLogin.getRole());
        return role.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return userLogin;
    }

    @Override
    public Object getPrincipal() {
        return userLogin;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return userLogin.getUsername();
    }
}

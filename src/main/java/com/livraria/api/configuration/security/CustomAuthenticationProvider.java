package com.livraria.api.configuration.security;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.services.impl.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserLogin userLogin = userLoginService.findUserLogin(userName);

        if(userLogin==null){
            throw new UsernameNotFoundException("usuario e/ou senha invalidos!");
        }
        boolean equalPasswords = passwordEncoder.matches(password, userLogin.getPassword());
        if(equalPasswords){
            return new CustomAuthentication(userLogin);
        }
        throw new UsernameNotFoundException("Usuario nao encontrado!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}

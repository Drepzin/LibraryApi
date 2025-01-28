package com.livraria.api.configuration.security;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.entitys.dtos.UserLoginDto;
import com.livraria.api.services.impl.UserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSocialSucessImpl extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserLoginService userLoginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken authenticationToken =  (OAuth2AuthenticationToken) authentication;
        String email = authenticationToken.getPrincipal().getAttribute("email");
        UserLogin userLogin = userLoginService.findUserEmail(email);
        if(userLogin == null){
            registryUser(email);
        }

        authentication = new CustomAuthentication(userLogin);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.onAuthenticationSuccess(request, response, authentication);
    }

    private UserLogin registryUser(String email){
        String password = "321";
        String username = emailTreatment(email);
        String role = "COMMON_USER";
        UserLoginDto newUser = new UserLoginDto(username, email, password, role);
        return userLoginService.addUser(newUser);
    }

    private String emailTreatment(String email){
        return email.substring(0, email.indexOf("@"));
    }
}

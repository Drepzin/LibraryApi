package com.livraria.api.UserLogin;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.services.impl.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserLoginRepoTest {

    @Autowired
    UserLoginService userLoginService;

    @Test
    public void hasAUser(){
        UserLogin userLogin = userLoginService.findUserLogin("dk");
        System.out.println("USUARIO: " + userLogin.toString());
    }
}

package com.livraria.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginViewController {

    @GetMapping("/login")
    public String goToLogin(){
        return "Login";
    }
}

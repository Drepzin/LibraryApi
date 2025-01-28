package com.livraria.api.controllers;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.entitys.dtos.UserLoginDto;
import com.livraria.api.services.impl.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserLogin")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity<UserLogin> addUser(@RequestBody UserLoginDto userLogin){
        return new ResponseEntity<>(userLoginService.addUser(userLogin), HttpStatus.CREATED);
    }
}


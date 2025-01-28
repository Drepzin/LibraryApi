package com.livraria.api.services.impl;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.entitys.dtos.UserLoginDto;
import com.livraria.api.mappers.UserLoginMapper;
import com.livraria.api.repositorys.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoginRepository userLoginRepository;

    public UserLogin addUser(UserLoginDto userLoginDto){
        UserLogin userLogin = UserLoginMapper.INSTANCE.dtoToEntity(userLoginDto);
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        return userLoginRepository.save(userLogin);
    }

    public UserLogin findUserLogin(String username){
        return userLoginRepository.findByUsername(username);
    }

    public UserLogin findUserEmail(String email){
        return userLoginRepository.findByEmail(email);
    }

}


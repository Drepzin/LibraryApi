package com.livraria.api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HelloLocked")
public class LockedController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHello(){
        return "Hello tirço";
    }
}

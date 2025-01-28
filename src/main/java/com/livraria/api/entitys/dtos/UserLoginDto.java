package com.livraria.api.entitys.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(String name, @Email @NotBlank String email, String password, String role) {
}

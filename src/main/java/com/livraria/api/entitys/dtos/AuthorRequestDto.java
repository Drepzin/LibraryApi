package com.livraria.api.entitys.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {

    @Size(max = 30, min = 3, message = "name to large")
    @NotBlank(message = "invalid field, name must have 3 characters")
    private String name;

    @Size(max = 20, min = 5, message = "invalid country")
    @NotBlank(message = "invalid country, country cannot be null!")
    private String nationality;

    @Past
    @NotNull(message = "invalid date, date cannot be null!")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

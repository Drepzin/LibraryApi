package com.livraria.api.entitys.dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {

    private String name;

    private String nationality;

    private LocalDate birthDate;

    private Integer publishedTitles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPublishedTitles() {
        return publishedTitles;
    }

    public void setPublishedTitles(Integer publishedTitles) {
        this.publishedTitles = publishedTitles;
    }

    public String getnationality() {
        return nationality;
    }

    public void setnationality(String nationality) {
        this.nationality = nationality;
    }
}

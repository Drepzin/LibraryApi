package com.livraria.api.entitys.dtos;

import com.livraria.api.entitys.Theme;

import java.time.LocalDate;

public record BookResponseDto(String title, Theme theme, LocalDate publicationDate,
                              Double price, String authorName, String nativeLanguage) {
}

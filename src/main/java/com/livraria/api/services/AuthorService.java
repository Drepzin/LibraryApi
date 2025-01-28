package com.livraria.api.services;

import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.dtos.AuthorRequestDto;
import com.livraria.api.entitys.dtos.AuthorResponseDto;

import java.util.List;

public interface AuthorService {

    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    AuthorResponseDto findAuthorById(Long id);

    void deleteAuthorById(Long id);

    AuthorResponseDto updateAuthorById(Long id, AuthorRequestDto authorRequestDto);

    List<AuthorResponseDto> findAllAuthors();

    List<Author> findAllByName(String name);

    AuthorResponseDto findByName(String name);


}

package com.livraria.api.services;

import com.livraria.api.entitys.Book;
import com.livraria.api.entitys.dtos.BookRequestDto;
import com.livraria.api.entitys.dtos.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    Page<BookResponseDto> findAllBooks(Integer pageNumber, Integer pageSize);

    BookResponseDto findBookById(Long id);

    BookResponseDto findBookByTitle(String title);

    void deleteBookById(Long id);

    void deleteBookByName(String name);

    BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto);
}

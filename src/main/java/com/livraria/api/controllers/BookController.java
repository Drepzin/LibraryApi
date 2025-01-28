package com.livraria.api.controllers;

import com.livraria.api.entitys.dtos.BookRequestDto;
import com.livraria.api.entitys.dtos.BookResponseDto;
import com.livraria.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequestDto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<BookResponseDto> patchABook(@PathVariable("id")Long id, @RequestBody BookRequestDto bookRequestDto){
        BookResponseDto bookResponseDto = bookService.updateBook(id, bookRequestDto);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<BookResponseDto>> findAllBooksPaged(@RequestParam(value = "page", defaultValue = "0")Integer page,
                                                                   @RequestParam(value = "size", defaultValue = "1") Integer size,
                                                                   Authentication authentication){

        return ResponseEntity.status(HttpStatus.FOUND).body(bookService.findAllBooks(page, size));
    }

    @DeleteMapping("{id}")
    public void deleteBookById(@PathVariable("id")Long id){
        bookService.deleteBookById(id);
    }
}

package com.livraria.api.handlers;

import com.livraria.api.exceptions.DuplicatedBook;
import com.livraria.api.exceptions.responses.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookHandler {

    @ExceptionHandler(DuplicatedBook.class)
    public ResponseEntity<ErrorResponseApi> duplicatedBook(DuplicatedBook book){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponseApi.duplicatedEntity("This book already registred in the library"));
    }
}

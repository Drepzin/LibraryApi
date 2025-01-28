package com.livraria.api.handlers;

import com.livraria.api.exceptions.DuplicatedAuthor;
import com.livraria.api.exceptions.InvalidEntity;
import com.livraria.api.exceptions.responses.ErrorResponseApi;
import com.livraria.api.exceptions.responses.FieldErrorApi;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class AuthorExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponseApi invalidArgumentHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<FieldErrorApi> streamList = fieldErrors.stream().
                map(fe -> new FieldErrorApi(fe.getDefaultMessage(), fe.getField())).toList();
        return new ErrorResponseApi("Invalid args!", HttpStatus.UNPROCESSABLE_ENTITY.value(), streamList);
    }

    @ExceptionHandler(DuplicatedAuthor.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseApi duplicatedAuthorHandler(DuplicatedAuthor e){
        return ErrorResponseApi.duplicatedEntity("duplicated Author!");
    }

    @ExceptionHandler(InvalidEntity.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseApi invalidAuthorHandler(InvalidEntity e){
        return new ErrorResponseApi("Inexistent author!", HttpStatus.NOT_FOUND.value(), List.of());
    }
}


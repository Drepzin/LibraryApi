package com.livraria.api.exceptions;

public class DuplicatedAuthor extends RuntimeException {
    public DuplicatedAuthor(String message) {
        super(message);
    }
}

package com.livraria.api.exceptions;

public class DuplicatedBook extends RuntimeException {
    public DuplicatedBook(String message) {
        super(message);
    }
}

package com.livraria.api.ApiUtils.validators;

import com.livraria.api.entitys.Book;
import com.livraria.api.exceptions.DuplicatedBook;
import com.livraria.api.repositorys.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookValidator {

    @Autowired
    BookRepo bookRepo;

    public void validateBook(Book book){
        if(isDuplicatedBook(book)){
            throw new DuplicatedBook("this book already exist in the library!");
        }
    }

    public boolean isDuplicatedBook(Book book){
        Optional<Book> optBook = bookRepo.findByTitle(book.getTitle());
        return optBook.isPresent();
    }
}

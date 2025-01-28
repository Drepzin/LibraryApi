package com.livraria.api.ApiUtils.updaters;

import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.Book;
import com.livraria.api.entitys.dtos.BookRequestDto;
import com.livraria.api.exceptions.InvalidEntity;
import com.livraria.api.repositorys.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookUpdater {

    @Autowired
    AuthorRepo authorRepo;

    public void updateBook(BookRequestDto bookRequestDto, Book book){
        if(bookRequestDto.title() != null){
            book.setTitle(bookRequestDto.title());
        }
        if(bookRequestDto.authorName()!=null){
            Optional<Author> optAuthor = authorRepo.findByName(bookRequestDto.authorName());
            if(optAuthor.isEmpty()){
                throw new InvalidEntity("invalid Author!");
            }
            book.setAuthor(optAuthor.get());
        }
        if(bookRequestDto.publicationDate()!=null){
            book.setPublicationDate(bookRequestDto.publicationDate());
        }
        if(bookRequestDto.theme() !=null){
            book.setTheme(bookRequestDto.theme());
        }
        if(bookRequestDto.price()!=null){
            book.setPrice(bookRequestDto.price());
        }
        if(bookRequestDto.nativeLanguage()!=null){
            book.setNativeLanguage(bookRequestDto.nativeLanguage());
        }
    }
}

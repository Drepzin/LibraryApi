package com.livraria.api.services.impl;

import com.livraria.api.ApiUtils.updaters.BookUpdater;
import com.livraria.api.ApiUtils.validators.BookValidator;
import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.Book;
import com.livraria.api.entitys.dtos.BookRequestDto;
import com.livraria.api.entitys.dtos.BookResponseDto;
import com.livraria.api.exceptions.InvalidEntity;
import com.livraria.api.mappers.BookMapper;
import com.livraria.api.repositorys.AuthorRepo;
import com.livraria.api.repositorys.BookRepo;
import com.livraria.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookValidator bookValidator;

    private BookUpdater bookUpdater;

    public BookServiceImpl(AuthorRepo authorRepo, BookValidator bookValidator,
                           BookRepo bookRepo, BookUpdater bookUpdater) {
        this.authorRepo = authorRepo;
        this.bookValidator = bookValidator;
        this.bookRepo = bookRepo;
        this.bookUpdater = bookUpdater;
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = BookMapper.INSTANCE.requestToEntity(bookRequestDto);
        Optional<Author> author = authorRepo.findByName(bookRequestDto.authorName());
        bookValidator.validateBook(book);
        if(author.isEmpty()){
          throw new InvalidEntity("author not found!");
        }
        book.setAuthor(author.get());
        return BookMapper.INSTANCE.entityToResponse(bookRepo.save(book));
    }

    @Override
    public Page<BookResponseDto> findAllBooks(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookRepo.findAll(pageable).map(BookMapper.INSTANCE::entityToResponse);
    }


    @Override
    public BookResponseDto findBookById(Long id) {
        Optional<Book> optBook = bookRepo.findById(id);
        isEmpty(optBook);
        return BookMapper.INSTANCE.entityToResponse(optBook.get());
    }

    @Override
    public BookResponseDto findBookByTitle(String title) {
        Optional<Book> optBook = bookRepo.findByTitle(title);
        isEmpty(optBook);
        return BookMapper.INSTANCE.entityToResponse(optBook.get());
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<Book> optBook = bookRepo.findById(id);
        isEmpty(optBook);
        bookRepo.deleteById(optBook.get().getId());
    }

    @Override
    public void deleteBookByName(String title) {
        Optional<Book> optBook = bookRepo.findByTitle(title);
        isEmpty(optBook);
        bookRepo.delete(optBook.get());
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto) {
        Optional<Book> optBook = bookRepo.findById(id);
        isEmpty(optBook);
        bookUpdater.updateBook(bookRequestDto, optBook.get());
        return BookMapper.INSTANCE.entityToResponse(bookRepo.save(optBook.get()));
    }

    public void isEmpty(Optional<Book> book){
        if(book.isEmpty()){
            throw new InvalidEntity("book not found!");
        }
    }
}

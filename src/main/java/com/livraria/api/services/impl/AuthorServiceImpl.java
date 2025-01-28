package com.livraria.api.services.impl;

import com.livraria.api.ApiUtils.updaters.AuthorUpdater;
import com.livraria.api.ApiUtils.utils.AuthorExampleQuery;
import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.dtos.AuthorRequestDto;
import com.livraria.api.entitys.dtos.AuthorResponseDto;
import com.livraria.api.exceptions.InvalidEntity;
import com.livraria.api.mappers.AuthorMapper;
import com.livraria.api.repositorys.AuthorRepo;
import com.livraria.api.services.AuthorService;
import com.livraria.api.ApiUtils.validators.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorValidator authorValidator;

    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = AuthorMapper.INSTANCE.requestToEntity(authorRequestDto);
        authorValidator.validate(author);
        authorRepo.save(author);
        return AuthorMapper.INSTANCE.entityToResponse(author);
    }

    @Override
    public AuthorResponseDto findAuthorById(Long id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new InvalidEntity("Author not found!");
        }
        return AuthorMapper.INSTANCE.entityToResponse(optionalAuthor.get());
    }

    @Override
    public void deleteAuthorById(Long id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new InvalidEntity("author inexistent");
        }
        authorRepo.deleteById(id);
    }

    @Override
    public AuthorResponseDto updateAuthorById(Long id, AuthorRequestDto authorRequestDto) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new InvalidEntity("");
        }
        AuthorUpdater.updateAuthor(optionalAuthor.get(), authorRequestDto);
        authorRepo.save(optionalAuthor.get());
        return AuthorMapper.INSTANCE.entityToResponse(optionalAuthor.get());
    }

    @Override
    public List<AuthorResponseDto> findAllAuthors() {
       return authorRepo.findAll().stream().
               map(AuthorMapper.INSTANCE::entityToResponse).toList();
    }

    @Override
    public List<Author> findAllByName(String name){
        return authorRepo.findAll(AuthorExampleQuery.authorExample(name));
    }

    @Override
    public AuthorResponseDto findByName(String name) {
        Optional<Author> optAuthor = authorRepo.findByName(name);
        if(optAuthor.isEmpty()){
            throw new InvalidEntity("invalid author name!");
        }
        return AuthorMapper.INSTANCE.entityToResponse(optAuthor.get());
    }
}

package com.livraria.api.controllers;

import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.dtos.AuthorRequestDto;
import com.livraria.api.entitys.dtos.AuthorResponseDto;
import com.livraria.api.exceptions.DuplicatedAuthor;
import com.livraria.api.exceptions.InvalidEntity;
import com.livraria.api.exceptions.responses.ErrorResponseApi;
import com.livraria.api.mappers.AuthorMapper;
import com.livraria.api.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Object> addAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto){
        return ResponseEntity.status(201).body(authorService.addAuthor(authorRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(authorService.findAuthorById(id), HttpStatus.FOUND);
        }
        catch (InvalidEntity e){
            var error = new ErrorResponseApi(e.getMessage(), HttpStatus.NOT_FOUND.value(), List.of());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> findAllAuthors(){
        return ResponseEntity.status(HttpStatus.FOUND).body(authorService.findAllAuthors());
    }

    /*
    @GetMapping(params = "name")
    public ResponseEntity<AuthorResponseDto> findAuthorByName(@RequestParam("name")String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(authorService.findByName(name));
    }

     */


    @GetMapping(params = "name")
    public ResponseEntity<List<AuthorResponseDto>> findAllAuthorsByName(@RequestParam("name") String name){
        List<Author> authorList = authorService.findAllByName(name);
        List<AuthorResponseDto> authorResponseDtoList = authorList.stream().
                map(AuthorMapper.INSTANCE::entityToResponse).toList();
        return new ResponseEntity<>(authorResponseDtoList, HttpStatus.FOUND);
    }


    @DeleteMapping("{id}")
    public void deleteAuthorById(@PathVariable(name = "id") Long id){
        authorService.deleteAuthorById(id);
    }

    @PatchMapping("{id}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable("id")Long id,@RequestBody AuthorRequestDto authorRequestDto){
        return new ResponseEntity<>(authorService.updateAuthorById(id, authorRequestDto), HttpStatus.OK);
    }
}

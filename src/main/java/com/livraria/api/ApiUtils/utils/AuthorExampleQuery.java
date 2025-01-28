package com.livraria.api.ApiUtils.utils;

import com.livraria.api.entitys.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class AuthorExampleQuery {

    public static Example<Author> authorExample(String name){
        Author author = new Author();author.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return Example.of(author, exampleMatcher);
    }
}

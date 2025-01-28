package com.livraria.api.ApiUtils.updaters;

import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.dtos.AuthorRequestDto;

public class AuthorUpdater {

    public static void updateAuthor(Author author, AuthorRequestDto authorRequestDto){
        if(authorRequestDto.getName()!=null){
            author.setName(authorRequestDto.getName());
        }
        if(authorRequestDto.getNationality()!=null){
            author.setNationality(authorRequestDto.getNationality());
        }
        if(authorRequestDto.getBirthDate()!=null){
            author.setBirthDate(authorRequestDto.getBirthDate());
        }
    }
}

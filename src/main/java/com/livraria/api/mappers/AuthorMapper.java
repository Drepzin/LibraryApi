package com.livraria.api.mappers;

import com.livraria.api.entitys.Author;
import com.livraria.api.entitys.dtos.AuthorRequestDto;
import com.livraria.api.entitys.dtos.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorResponseDto entityToResponse(Author author);

    Author requestToEntity(AuthorRequestDto authorRequestDto);
}

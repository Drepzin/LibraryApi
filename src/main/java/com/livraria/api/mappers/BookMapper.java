package com.livraria.api.mappers;

import com.livraria.api.entitys.Book;
import com.livraria.api.entitys.dtos.BookRequestDto;
import com.livraria.api.entitys.dtos.BookResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book requestToEntity(BookRequestDto bookRequestDto);

    @Mapping(target = "authorName", source = "author.name")
    BookResponseDto entityToResponse(Book book);
}

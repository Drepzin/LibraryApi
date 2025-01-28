package com.livraria.api.mappers;

import com.livraria.api.entitys.UserLogin;
import com.livraria.api.entitys.dtos.UserLoginDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserLoginMapper {

    public UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);

    @Mapping(target = "username", source = "name")
    UserLogin dtoToEntity(UserLoginDto userLoginDto);
}

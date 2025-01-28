package com.livraria.api.exceptions.responses;

import org.springframework.http.HttpStatus;
import java.util.List;

public record ErrorResponseApi(String message, int value, List<FieldErrorApi> fieldErrorApis) {

    public static ErrorResponseApi conflict(String msg){
        return new ErrorResponseApi(msg, HttpStatus.CONFLICT.value(), List.of());
    }

    public static ErrorResponseApi duplicatedEntity(String msg){
        return new ErrorResponseApi(msg, HttpStatus.NOT_ACCEPTABLE.value(), List.of());
    }



}

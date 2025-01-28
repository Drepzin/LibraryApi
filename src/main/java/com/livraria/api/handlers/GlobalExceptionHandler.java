package com.livraria.api.handlers;

//Exception handler to treat the general server errors!
import com.livraria.api.exceptions.responses.ServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<ServerErrorResponse> internalServerError(HttpServerErrorException.InternalServerError e){
        return new ResponseEntity<>(ServerErrorResponse.internalError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<ServerErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>(ServerErrorResponse.methodNotAllowed(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}

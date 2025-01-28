package com.livraria.api.exceptions.responses;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ServerErrorResponse {

    private String error;

    private int value;

    private LocalDateTime localDateTime = LocalDateTime.now();

    public ServerErrorResponse() {
    }

    public ServerErrorResponse(String error, int value) {
        this.error = error;
        this.value = value;
    }

    public static ServerErrorResponse internalError(){
        return new ServerErrorResponse("Unexpected internal server error!", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static ServerErrorResponse methodNotAllowed(){
        return new ServerErrorResponse("you cannot invoke this method in this way!", HttpStatus.METHOD_NOT_ALLOWED.value());
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServerErrorResponse{" +
                "error='" + error + '\'' +
                ", value=" + value +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

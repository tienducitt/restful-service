package com.eventgate.backend.service.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class HttpException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public HttpException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}

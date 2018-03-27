package com.eventgate.backend.service.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class HttpException extends RuntimeException {

    private HttpStatus status;

    public HttpException(HttpStatus status) {
        super(status.value() + " " + status.getReasonPhrase());
        this.status = status;
    }
}

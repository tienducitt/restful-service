package com.eventgate.backend.service.controller;

import org.springframework.http.HttpStatus;

public class ResponseFactory {

    public static Response exception(HttpStatus status, Throwable ex) {
        return fail(status, "Something wrong in ourside. Please try again later.", ex.getLocalizedMessage());
    }

    public static Response exception(HttpStatus status, String message, Throwable ex) {
        return fail(status, message, ex.getLocalizedMessage());
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK, data);
    }

    public static <T> Response<T> success(T data, ExtraInfo extra) {
        return new Response<>(HttpStatus.OK, data, null, extra);
    }

    public static Response fail(HttpStatus status, String message, Object rejectedValue) {
        Response response = new Response(status, null, null, null);
        response.addError(new Error("-", null, rejectedValue, message));

        return response;
    }

    public static Response fail(HttpStatus status, String message) {
        return fail(status, message, null);
    }
}

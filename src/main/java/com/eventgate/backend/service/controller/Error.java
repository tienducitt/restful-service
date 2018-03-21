package com.eventgate.backend.service.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    private String object;
    private @NonNull String field;
    private Object rejectedValue;
    private @NonNull String message;

    public Error(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }
}

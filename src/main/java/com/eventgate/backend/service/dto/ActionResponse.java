package com.eventgate.backend.service.dto;

public class ActionResponse {
    private int code;
    private String message;

    public ActionResponse() {
    }

    public ActionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ActionResponse success(String message) {
        return new ActionResponse(1, message);
    }

    //region Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //endregion
}

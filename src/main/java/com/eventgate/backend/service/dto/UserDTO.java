package com.eventgate.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class UserDTO {
    @ApiModelProperty(notes = "id")
    private int id;

    @NotEmpty
    @ApiModelProperty(notes = "username", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(notes = "password", required = true)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.eventgate.backend.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Data
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
}

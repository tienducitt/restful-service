package com.eventgate.backend.service.controller.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data @Setter @Getter
public class AuthDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

package com.eventgate.backend.service.controller.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data @Setter @Getter
public class AuthDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}

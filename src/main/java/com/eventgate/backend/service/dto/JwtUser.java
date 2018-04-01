package com.eventgate.backend.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser
{
    private String email;
    private String role;
}
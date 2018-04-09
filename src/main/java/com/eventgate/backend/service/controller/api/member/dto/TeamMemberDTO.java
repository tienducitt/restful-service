package com.eventgate.backend.service.controller.api.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamMemberDTO {
    private int id;
    private String email;
    private String avatar;
    private String role;
    private Date createdAt;
    private Date updatedAt;
}

package com.eventgate.backend.service.controller.api.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDefault;
    private int totalMember;
    private int totalEvent;

    private List<TeamMemberDTO> users;
}

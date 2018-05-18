package com.eventgate.backend.service.controller.api.member.dto.team;

import com.eventgate.backend.service.model.MemberRole;
import lombok.Data;

@Data
public class AddMemberDTO {
    private int userId;
    private MemberRole role;
}

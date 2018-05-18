package com.eventgate.backend.service.controller.api.member.dto.team;

import com.eventgate.backend.service.model.MemberRole;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamOfMemberDTO {
    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDefault;
    private MemberRole role;

    public TeamOfMemberDTO(TeamMember teamMember) {
        this(teamMember.getPk().getTeam());
        this.role = teamMember.getRole();
    }

    public TeamOfMemberDTO(Team team) {
        BeanUtils.copyProperties(team, this);
    }
}

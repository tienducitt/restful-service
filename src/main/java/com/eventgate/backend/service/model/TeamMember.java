package com.eventgate.backend.service.model;

import lombok.Data;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "team_member")
@AssociationOverrides({
        @AssociationOverride(name = "pk.team",
                joinColumns = @JoinColumn(name = "team_id")),
        @AssociationOverride(name = "pk.member",
                joinColumns = @JoinColumn(name = "member_id"))})
public class TeamMember {

    @EmbeddedId
    private TeamMemberId pk = new TeamMemberId();

    private MemberRole role;
    private boolean isDefault;
}

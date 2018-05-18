package com.eventgate.backend.service.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class TeamMemberId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    @ManyToOne(fetch = FetchType.LAZY)
    private User member;
}

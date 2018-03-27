package com.eventgate.backend.service.controller.api.v1;

import com.eventgate.backend.service.exception.EntityNotFoundException;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.model.TeamMember;
import com.eventgate.backend.service.repository.TeamMemberRepository;
import com.eventgate.backend.service.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/teams/{teamId}/members")
public class TeamMemberController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamMemberRepository teamMemberRepository;

    @GetMapping
    public List<TeamMember> getMembers(@PathVariable int teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));

        return team.getMembers();
    }
}

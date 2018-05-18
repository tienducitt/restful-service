package com.eventgate.backend.service.controller.api.member;

import com.eventgate.backend.service.controller.api.member.dto.team.AddMemberDTO;
import com.eventgate.backend.service.controller.api.member.dto.team.TeamOfMemberDTO;
import com.eventgate.backend.service.exception.EntityNotFoundException;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.model.TeamMember;
import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.TeamMemberRepository;
import com.eventgate.backend.service.repository.TeamRepository;
import com.eventgate.backend.service.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/member/teams/{teamId}/members")
@Api(description = "Member team controller")
public class MTeamMemberController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping
    public List<TeamMember> getList() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("{memberId}")
    public TeamMember get(@PathVariable int memberId) {
        throw new UnsupportedOperationException();
    }

    @PostMapping()
    public AddMemberDTO addMember(@PathVariable int teamId, @RequestBody AddMemberDTO dto) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException(User.class, "id", dto.getUserId()));

        TeamMember teamMember = new TeamMember();
        teamMember.getPk().setTeam(team);
        teamMember.getPk().setMember(user);
        teamMember.setRole(dto.getRole());

        teamMemberRepository.save(teamMember);

        return dto;
    }

    @DeleteMapping("{memberId}")
    public TeamOfMemberDTO removeMember(@PathVariable int teamId, @PathVariable int memberId) {
        throw new UnsupportedOperationException("");
    }
}

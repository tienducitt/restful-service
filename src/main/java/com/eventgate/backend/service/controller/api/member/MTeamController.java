package com.eventgate.backend.service.controller.api.member;

import com.eventgate.backend.service.controller.api.member.dto.team.TeamOfMemberDTO;
import com.eventgate.backend.service.dto.JwtUser;
import com.eventgate.backend.service.exception.EntityNotFoundException;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.model.TeamMember;
import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.TeamRepository;
import com.eventgate.backend.service.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/member/teams")
@Api(description = "Member team controller")
public class MTeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping()
    public List<TeamOfMemberDTO> getList(@RequestAttribute JwtUser jwtUser) {
        User user = userRepository.findByEmail(jwtUser.getEmail());
        List<TeamMember> teamMembers = user.getTeamMembers();

        List<TeamOfMemberDTO> ret = new ArrayList<>();
        for (TeamMember teamMember : teamMembers) {
            ret.add(new TeamOfMemberDTO(teamMember));
        }
        return ret;
    }

    @GetMapping("/{teamId}")
    public TeamOfMemberDTO getDetail(@PathVariable int teamId, @RequestAttribute JwtUser jwtUser) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));

        return new TeamOfMemberDTO(team);
    }

    @PostMapping()
    public TeamOfMemberDTO post(@PathVariable int teamId, TeamOfMemberDTO teamDTO) {

        throw new UnsupportedOperationException("");
    }

    @PutMapping("/{teamId}")
    public TeamOfMemberDTO put(@PathVariable int teamId, TeamOfMemberDTO teamDTO) {
        throw new UnsupportedOperationException("");
    }

    @DeleteMapping("/{teamId}")
    public TeamOfMemberDTO delete(@PathVariable int teamId) {
        throw new UnsupportedOperationException("");
    }

}

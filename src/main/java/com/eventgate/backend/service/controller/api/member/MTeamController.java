package com.eventgate.backend.service.controller.api.member;

import com.eventgate.backend.service.controller.api.member.dto.TeamDTO;
import com.eventgate.backend.service.controller.api.member.dto.TeamMemberDTO;
import com.eventgate.backend.service.dto.JwtUser;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/member/teams")
@Api(description = "Member team controller")
public class MTeamController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<TeamDTO> getList(@RequestAttribute JwtUser jwtUser) {
        User user = userRepository.findByEmail(jwtUser.getEmail());
        List<TeamMember> teams = user.getTeams();
        return null;
    }

    @GetMapping("/{teamId}")
    public TeamDTO get(@PathVariable int teamId, @RequestAttribute JwtUser user) {
        throw new UnsupportedOperationException("");
    }

    @PutMapping("/{teamId}")
    public TeamDTO put(@PathVariable int teamId, TeamDTO teamDTO) {
        throw new UnsupportedOperationException("");
    }

    @PostMapping("/{teamId}/members")
    public TeamDTO addMember(@PathVariable int teamId, @RequestBody TeamMemberDTO dto) {
        throw new UnsupportedOperationException("");
    }

    @DeleteMapping("/{teamId}/members/{memberId}")
    public TeamDTO removeMember(@PathVariable int teamId, @PathVariable int memberId) {
        throw new UnsupportedOperationException("");
    }
}

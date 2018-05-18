package com.eventgate.backend.service.service;

import com.eventgate.backend.service.model.MemberRole;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.model.TeamMember;
import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.TeamRepository;
import com.eventgate.backend.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && password.equals(user.getPassword());
    }

    @Transactional
    public User save(User user) {
        Team team = new Team();
        team.setName(user.getEmail());
        team.setDefault(true);

        team = teamRepository.save(team);

        TeamMember teamMember = new TeamMember();
        teamMember.getPk().setMember(user);
        teamMember.getPk().setTeam(team);
        teamMember.setRole(MemberRole.ADMIN);
        teamMember.setDefault(true);

        user.getTeamMembers().add(teamMember);
        // Save user
        user = userRepository.save(user);

        // ignore teamMembers
        user.setTeamMembers(null);
        return user;
    }
}

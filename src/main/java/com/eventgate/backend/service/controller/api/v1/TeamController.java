package com.eventgate.backend.service.controller.api.v1;

import com.eventgate.backend.service.controller.EntityNotFoundException;
import com.eventgate.backend.service.model.Team;
import com.eventgate.backend.service.repository.TeamRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "team controller")
@RestController
@RequestMapping(value = "/api/v1/teams")
public class TeamController {

    @Autowired
    TeamRepository teamRepo;

    @GetMapping
    public List<Team> list() {
        return teamRepo.findAll();
    }

    @GetMapping(value = "{teamId}")
    public Team get(@Valid @PathVariable int teamId) {
        return teamRepo.findById(teamId).orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamRepo.save(team);
    }

    @PutMapping(value = "{teamId}")
    public Team update(@PathVariable int teamId, @Valid @RequestBody Team input) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));
        team.setName(team.getName());

        return teamRepo.save(team);
    }

    @DeleteMapping(value = "{teamId}")
    public Team delete(@PathVariable int teamId) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId));
        teamRepo.delete(team);

        return team;
    }
}

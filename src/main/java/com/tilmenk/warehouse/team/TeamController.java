package com.tilmenk.warehouse.team;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api" + "/team")
@AllArgsConstructor
public class TeamController {
    @Autowired
    private final TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        System.out.println("test");
        return teamService.getTeams();
    }

    @PostMapping
    public void createTeam() {
        teamService.createTeam();
    }


}

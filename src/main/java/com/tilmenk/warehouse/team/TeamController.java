package com.tilmenk.warehouse.team;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api" + "/team")
@AllArgsConstructor
public class TeamController {
    @Autowired
    private final TeamService teamService;

    @Operation(summary = "get all teams")

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }


}



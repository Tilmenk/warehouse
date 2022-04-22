package com.tilmenk.warehouse.team;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "get all teams")
   /* @ApiResponses(value = {@ApiResponse(responseCode = "200", description =
            "Found the book", content = {@Content(mediaType =
            "application" + "/json", schema = @Schema(implementation =
            Book.class))}), @ApiResponse(responseCode = "400", description =
            "Invalid id " + "supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found"
                    , content = @Content)})*/
    @GetMapping
    public List<Team> getTeams() {
        System.out.println("test");
        return teamService.getTeams();
    }

    @Operation(summary = "create a team")
    @PostMapping
    public void createTeam() {
        teamService.createTeam();
    }


}



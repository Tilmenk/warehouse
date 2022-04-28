package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.pokemon.Pokemon;
import com.tilmenk.warehouse.pokemon.PokemonService;
import com.tilmenk.warehouse.team.exceptions.PokemonNotInDbException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestPropertySource(properties = {"DEPLOYMENT_ENV=test"})
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TeamServiceTest {

    @Autowired
    TeamService teamService;
    @Autowired
    PokemonService pokemonService;

    @Test
    void shouldAddTeamToDb() {
        //GIVEN
        Pokemon pokemon = new Pokemon("testPoke", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        Team team = new Team(List.of(pokemon), "default-1");
        pokemonService.savePokemon(pokemon);
        //WHEN
        teamService.saveTeam(team);
        //THEN
        assertEquals("default-1", teamService.getTeams().get(0).getName());
    }

    @Test
    void shouldThrowPokemonNotInDbExceptionWithPokemonName() {
        //GIVEN
        Pokemon pokemon = new Pokemon("testPoke", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        Team team = new Team(List.of(pokemon), "default-1");
        //WHEN
        PokemonNotInDbException pokemonNotInDbException =
                assertThrows(PokemonNotInDbException.class, () -> {
            teamService.saveTeam(team);
        });
        //THEN

        assertEquals("Pokemon with name '" + "testPoke" + "' is not present " + "in Pokemon table.", pokemonNotInDbException.getMessage());
    }


}

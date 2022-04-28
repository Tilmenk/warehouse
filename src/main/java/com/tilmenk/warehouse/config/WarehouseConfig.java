package com.tilmenk.warehouse.config;


import com.tilmenk.warehouse.model.Pokemon;
import com.tilmenk.warehouse.model.Team;
import com.tilmenk.warehouse.service.PokemonService;
import com.tilmenk.warehouse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Objects;

@Configuration
public class WarehouseConfig {

    @Autowired
    private Environment env;

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private TeamService teamService;

    @Bean
    CommandLineRunner commandLineRunnerWarehouse() {
        return args -> {
            Pokemon pikachu = new Pokemon("pikachu", "Electric", "none", 60,
                    45, 49, 65, 65, 45, false);
            Pokemon bulbasaur = new Pokemon("bulbasaur", "Grass", "Poison",
                    45, 49, 49, 65, 65, 45, false);
            Team team = new Team(List.of(pikachu, bulbasaur), "default-1");
            if (Objects.equals(env.getProperty("DEPLOYMENT_ENV"), "dev")) {

                //TODO: @Tilmann, hier die csv imports aufrufen -> nur
                // pokemonService und teamService verwenden ( nicht
                // repository 

                pokemonService.savePokemon(pikachu);
                pokemonService.savePokemon(bulbasaur);
                teamService.saveTeam(team);
            }
            // TODO Here comes the CSV-Calls
            //Pokemon pokemon = pokemonService.findPokemonByName("pikachu");
            //Find All -> No doubles.
        };
    }
}
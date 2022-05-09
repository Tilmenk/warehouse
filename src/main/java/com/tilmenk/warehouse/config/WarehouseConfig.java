package com.tilmenk.warehouse.config;


import com.tilmenk.warehouse.model.Pokemon;
import com.tilmenk.warehouse.model.Team;
import com.tilmenk.warehouse.service.PokemonService;
import com.tilmenk.warehouse.service.TeamService;
import com.tilmenk.warehouse.util.csvReader.CustomReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

import static com.tilmenk.warehouse.util.csvReader.CSVRead.parsePokemon;

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
            Pokemon moltres = new Pokemon("moltres", "Grass", "Poison", 45,
                    49, 49, 65, 65, 45, true);
            Team team = new Team(List.of(pikachu, bulbasaur, pikachu,
                    bulbasaur, pikachu, bulbasaur), "default-1");
            //if (Objects.equals(env.getProperty("DEPLOYMENT_ENV"), "dev")) {
            System.out.println(env.getProperty("HENK_ENV"));
            //TODO: @Tilmann, hier die csv imports aufrufen -> nur
            // pokemonService und teamService verwenden ( nicht
            // repository

            CustomReader customReader = new CustomReader();
            try {
                List<String[]> result = customReader.readLines("src/main" +
                        "/resources" + "/csv" + "/pokemon_1.csv");
                result.remove(0);
                for (String[] stringArr : result) {
                    System.out.println("------------------ STRING ARRAY ");
                    for (String string : stringArr) {
                        System.out.println(string);
                    }
                    pokemonService.savePokemon(parsePokemon(stringArr));
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

           /* pokemonService.savePokemon(pikachu);
            pokemonService.savePokemon(bulbasaur);
            pokemonService.savePokemon(moltres);*/
            //teamService.saveTeam(team);
            // }

            Team teamFromReadPokemon =
                    new Team(List.of(pokemonService.getPokemon().get(0),
                            pokemonService.getPokemon().get(1),
                            pokemonService.getPokemon().get(2),
                            pokemonService.getPokemon().get(3),
                            pokemonService.getPokemon().get(4),
                            pokemonService.getPokemon().get(5)), "default-1");
            teamService.saveTeam(teamFromReadPokemon);

            // TODO Here comes the CSV-Calls
            //Pokemon pokemon = pokemonService.findPokemonByName("pikachu");
            //Find All -> No doubles.
        };
    }
}
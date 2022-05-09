package com.tilmenk.warehouse.config;


import com.tilmenk.warehouse.model.Pokemon;
import com.tilmenk.warehouse.model.Team;
import com.tilmenk.warehouse.repository.PokemonRepository;
import com.tilmenk.warehouse.service.PokemonService;
import com.tilmenk.warehouse.service.TeamService;
import com.tilmenk.warehouse.util.csvReader.CustomReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.tilmenk.warehouse.util.csvReader.CSVRead.parsePokemon;

@Configuration
public class WarehouseConfig {

    @Autowired
    private Environment env;

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private PokemonRepository pokemonRepository;

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
                List<String[]> pokemonLines = customReader.readLines("src" +
                        "/main" + "/resources" + "/csv" + "/pokemon_1.csv");
                List<String[]> teamLines =
                        customReader.readLines("src/main" + "/resources" +
                                "/csv" + "/teams_1.csv");
                pokemonLines.remove(0);
                teamLines.remove(0);
                for (String[] stringArr : pokemonLines) {
                    pokemonService.savePokemon(parsePokemon(stringArr));
                }

                for (String[] stringArr : teamLines) {
                    List<String> stringArrAsList =
                            new ArrayList<>(List.of(stringArr));
                    String teamName = stringArrAsList.get(1);
                    stringArrAsList.remove(0);
                    stringArrAsList.remove(0);
                    List<Pokemon> pokemonInTeam = new ArrayList<>();

                    for (String pokeName : stringArrAsList) {
                        Optional<Pokemon> pokemon =
                                pokemonRepository.findPokemonByName(pokeName);
                        assert pokemon.isPresent();
                        pokemonInTeam.add(pokemon.get());
                    }
                    Team teamToAdd = new Team(pokemonInTeam, teamName);
                    teamService.saveTeam(teamToAdd);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


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
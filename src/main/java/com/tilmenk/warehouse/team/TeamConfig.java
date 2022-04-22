package com.tilmenk.warehouse.team;


import com.tilmenk.warehouse.pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class TeamConfig {
    @Autowired
    private Environment env;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Bean
    CommandLineRunner commandLineRunnerTeam(PokemonRepository pokemonRepository) {

        return args -> {

        };
    }
}
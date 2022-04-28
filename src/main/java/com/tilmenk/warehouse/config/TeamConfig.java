package com.tilmenk.warehouse.config;


import com.tilmenk.warehouse.repository.PokemonRepository;
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

    @Autowired
    private TeamRepository teamRepository;

    @Bean
    CommandLineRunner commandLineRunnerTeam(PokemonRepository pokemonRepository) {

        return args -> {
            //Here all the calls are coming in.
        };
    }

}
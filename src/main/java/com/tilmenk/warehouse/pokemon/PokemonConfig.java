package com.tilmenk.warehouse.pokemon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Objects;

@Configuration
public class PokemonConfig {
    @Autowired
    private Environment env;

    @Bean
    CommandLineRunner commandLineRunnerPokemon(PokemonRepository repository) {
        return args -> {
            Pokemon pikachu = new Pokemon("pikachu", "Electric", "none", 60,
                    45, 49, 65, 65, 45, false);
            Pokemon bulbasaur = new Pokemon("bulbasaur", "Grass", "Poison",
                    45, 49, 49, 65, 65, 45, false);
            if (Objects.equals(env.getProperty("DEPLOYMENT_ENV"), "dev")) {
                repository.saveAll(List.of(pikachu, bulbasaur));
            }
        };
    }
}
package com.tilmenk.warehouse.pokemon;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PokemonConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 22));
            Student alex = new Student("Alex", "alex.jamal@gmail.com",
                    LocalDate.of(2004, Month.APRIL, 22));
            if (System.getenv("DEPLOYMENT_ENV").equals("dev")) {
                repository.saveAll(List.of(mariam, alex));
            }
        };
    }
}
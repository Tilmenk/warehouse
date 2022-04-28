package com.tilmenk.warehouse.service;

import com.tilmenk.warehouse.exceptions.PokemonAlreadyInDbException;
import com.tilmenk.warehouse.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestPropertySource(properties = {"DEPLOYMENT_ENV=test"})
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PokemonServiceTest {

    @Autowired
    PokemonService pokemonService;

    @Test
    void shouldAddPokemonToDb() {
        //GIVEN
        Pokemon pokemon = new Pokemon("testPoke", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        pokemonService.savePokemon(pokemon);
        //THEN
        assertEquals("testPoke", pokemonService.getPokemon().get(0).getName());
    }

    @Test
    void shouldThrowPokemonAlreadyInDbExceptionWithPokemonName() {
        //GIVEN
        Pokemon pokemon = new Pokemon("testPoke", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //WHEN

        //THEN
        PokemonAlreadyInDbException pokemonAlreadyInDbException =
                assertThrows(PokemonAlreadyInDbException.class, () -> {
            pokemonService.savePokemon(pokemon);
            pokemonService.savePokemon(pokemon);
        });
        assertEquals("Pokemon with name 'testPoke' is already present in " +
                "Pokemon table.", pokemonAlreadyInDbException.getMessage());
    }


}

package com.tilmenk.warehouse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {


    @Test
    void testConstructor() {
        //GIVEN
        //WHEN
        Pokemon pokemon = new Pokemon("pikachu", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //THEN
        assertEquals("pikachu", pokemon.getName());
    }

}

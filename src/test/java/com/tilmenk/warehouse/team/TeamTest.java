package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.pokemon.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {
    
    @Test
    void testConstructor() {
        //GIVEN
        Pokemon pokemon = new Pokemon("pikachu", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        Team team = new Team(pokemon, pokemon, pokemon, pokemon, pokemon,
                pokemon);
        //THEN
        assertEquals("pikachu", team.getPokemon_0().getName());
    }
}

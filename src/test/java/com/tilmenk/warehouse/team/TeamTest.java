package com.tilmenk.warehouse.team;

import com.tilmenk.warehouse.model.pokemon.Pokemon;
import com.tilmenk.warehouse.model.team.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TeamTest {

    @Test
    void testConstructor_Pokemon() {
        //GIVEN
        Pokemon pokemon = new Pokemon("pikachu", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        Team team = new Team(List.of(pokemon), "default-1");

        //THEN
        Assertions.assertEquals("pikachu", team.getPokemon().get(0).getName());
    }

    @Test
    void testConstructor_Name() {
        //GIVEN
        Pokemon pokemon = new Pokemon("pikachu", "Electric", "none", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        Team team = new Team(List.of(pokemon), "default-1");

        //THEN
        Assertions.assertEquals("default-1", team.getName());
    }

}

package com.tilmenk.warehouse.csvReader;

import com.tilmenk.warehouse.pokemon.Pokemon;
import org.junit.jupiter.api.Test;

import static com.tilmenk.warehouse.csvReader.CSVRead.pokemonParser;
import static org.junit.jupiter.api.Assertions.*;

class TestCSVRead {

    @Test
    void readLines() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void readPokemon() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void testReadLines() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void testReadPokemon() {
        //GIVEN

        //WHEN

        //THEN

    }

    @Test
    void testPokemonParser() {
        //GIVEN
        String[] readString = {"pikachu", "electric","", "60", "45", "49", "65", "65", "45","false" };
        Pokemon pikachu =  new Pokemon("pikachu", "electric", "", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        Pokemon pokemon = pokemonParser(readString);
        //THEN
        assertEquals(pikachu.getName(), pokemon.getName());
        assertEquals(pikachu.getType1(), pokemon.getType1());
        assertEquals(pikachu.getType2(), pokemon.getType2());
        assertEquals(pikachu.getHealth(), pokemon.getHealth());
        assertEquals(pikachu.getAttack(), pokemon.getAttack());
        assertEquals(pikachu.getDefense(), pokemon.getDefense());
        assertEquals(pikachu.getAttack_sp(), pokemon.getAttack_sp());
        assertEquals(pikachu.getDefense_sp(), pokemon.getDefense_sp());
        assertEquals(pikachu.isLegendary(), pokemon.isLegendary());

    }
}
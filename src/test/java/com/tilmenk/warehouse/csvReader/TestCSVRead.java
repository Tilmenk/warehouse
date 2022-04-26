package com.tilmenk.warehouse.csvReader;

import com.tilmenk.warehouse.pokemon.Pokemon;
import org.junit.jupiter.api.Test;
import com.tilmenk.warehouse.csvReader.CSVRead.*;

import java.util.List;

import static com.tilmenk.warehouse.csvReader.CSVRead.*;
import static org.junit.jupiter.api.Assertions.*;

class TestCSVRead {

    @Test
    void testReadLines() {
        //GIVEN
        String path = "./testCSV.test";
        //WHEN
        List<String[]> result = null;
        try {
            result = readLines(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        //THEN
        assertEquals(4, result.size());
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
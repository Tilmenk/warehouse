package com.tilmenk.warehouse.csvReader;

import com.tilmenk.warehouse.pokemon.Pokemon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tilmenk.warehouse.csvReader.CSVRead.pokemonParser;
import static com.tilmenk.warehouse.csvReader.CSVRead.readLines;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestCSVRead {

    @Test
    void testReadLines() {
        //GIVEN
        String path = "/src/test/com.tilmenk.warehouse/csvReader/testCSV.csv";
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
        fail();
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
package com.tilmenk.warehouse.csvReader;

import com.opencsv.exceptions.CsvValidationException;
import com.tilmenk.warehouse.csvReader.CSVRead.*;
import com.tilmenk.warehouse.pokemon.Pokemon;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.tilmenk.warehouse.csvReader.CSVRead.parsePokemon;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

class TestCSVRead {

    @Test
    void testReadPokemon() throws CsvValidationException, IOException, URISyntaxException {
        //GIVEN
        CustomReader readerMock = Mockito.mock(CustomReader.class);
        List<String[]> list = new ArrayList<>();
        String[] readString = {"pikachu", "electric","", "60", "45", "49", "65", "65", "45","false" };
        list.add(readString);
        String dummyPath = "dummy/Path";
        CSVRead reader = new CSVRead(readerMock);
        //WHEN
        Mockito.when(readerMock.readLines(dummyPath)).thenReturn(list);
        List<Pokemon> res = reader.readPokemon(dummyPath);
        //THEN
        assertEquals(1, res.size());
    }

    @Test
    void testPokemonParser() {
        //GIVEN
        String[] readString = {"pikachu", "electric","", "60", "45", "49", "65", "65", "45","false" };
        Pokemon pikachu =  new Pokemon("pikachu", "electric", "", 60, 45,
                49, 65, 65, 45, false);
        //WHEN
        Pokemon pokemon = parsePokemon(readString);
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
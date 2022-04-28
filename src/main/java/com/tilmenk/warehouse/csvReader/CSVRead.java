package com.tilmenk.warehouse.csvReader;

import java.util.ArrayList;
import java.util.List;

import com.tilmenk.warehouse.pokemon.Pokemon;


public class CSVRead {
    private CustomReader reader;

    public CSVRead(CustomReader reader) {
        this.reader = reader;
    }

    public CSVRead() {
        this.reader = new CustomReader();
    }

    List<Pokemon> readPokemon(String path) {
        List<String[]> readStrings = new ArrayList<>();
        List<Pokemon> pokemonList = new ArrayList<>();
        try {
            readStrings = reader.readLines(path);
        } catch (Exception e) {
            System.err.println(e.getCause() + " // " + e.getMessage());
        }
        if (readStrings.isEmpty()) return null;
        for (String[] strings : readStrings
        ) {
            pokemonList.add(parsePokemon(strings));
        }
        return pokemonList;
    }

    static Pokemon parsePokemon(String[] readPokemon) {
        return new Pokemon(
                readPokemon[0], //string name
                readPokemon[1], //string typ1
                readPokemon[2], //string typ2
                Integer.parseInt(readPokemon[3]), //Int health
                Integer.parseInt(readPokemon[4]), // Int attack
                Integer.parseInt(readPokemon[5]), //Int defense
                Integer.parseInt(readPokemon[6]), //Int attack_sp
                Integer.parseInt(readPokemon[7]), //Int defense_sp
                Integer.parseInt(readPokemon[8]), //Int speed
                Boolean.parseBoolean(readPokemon[9]) //Boolean legendary
        );
    }
}

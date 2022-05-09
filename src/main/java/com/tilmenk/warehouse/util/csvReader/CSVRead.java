package com.tilmenk.warehouse.util.csvReader;


import com.tilmenk.warehouse.model.Pokemon;

import java.util.ArrayList;
import java.util.List;


public class CSVRead {
    private final CustomReader reader;

    public CSVRead(CustomReader reader) {
        this.reader = reader;
    }

    public CSVRead() {
        this.reader = new CustomReader();
    }

    public static Pokemon parsePokemon(String[] readPokemon) {
        return new Pokemon(readPokemon[1], //string name
                readPokemon[2], //string typ1
                readPokemon[3], //string typ2
                Integer.parseInt(readPokemon[4]), //Int health
                Integer.parseInt(readPokemon[5]), // Int attack
                Integer.parseInt(readPokemon[6]), //Int defense
                Integer.parseInt(readPokemon[7]), //Int attack_sp
                Integer.parseInt(readPokemon[8]), //Int defense_sp
                Integer.parseInt(readPokemon[9]), //Int speed
                Boolean.parseBoolean(readPokemon[10]) //Boolean legendary
        );
    }

    public List<Pokemon> readPokemon(String path) {
        List<String[]> readStrings = new ArrayList<>();
        List<Pokemon> pokemonList = new ArrayList<>();
        try {
            readStrings = reader.readLines(path);
        } catch (Exception e) {
            System.err.println(e.getCause() + " // " + e.getMessage());
        }
        if (readStrings.isEmpty()) return pokemonList;
        for (String[] strings : readStrings) {
            pokemonList.add(parsePokemon(strings));
        }
        return pokemonList;
    }
}

package com.tilmenk.warehouse.csvReader;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.tilmenk.warehouse.pokemon.Pokemon;


public class CSVRead {

    List<String[]> readLines(String path) throws CsvValidationException, IOException, URISyntaxException {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(path).toURI()));
        CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();
        CSVReader csvreader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();
        List<String[]> listOfRows = new ArrayList<>();
        String[] line;
        while ((line = csvreader.readNext()) != null) {
            listOfRows.add(line);
        }
        reader.close();
        return listOfRows;
    }

    List<Pokemon> readPokemon(String path) {
        List<String[]> readStrings = new ArrayList<>();
        List<Pokemon> pokemonList = new ArrayList<>();
        try {
            readStrings = readLines(path);
        } catch (Exception e) {
            System.err.println(e.getCause() + " // " + e.getMessage());
        }
        if (readStrings.isEmpty()) return null;
        for (String[] strings : readStrings
        ) {
            pokemonList.add(pokemonParser(strings));
        }
        return pokemonList;
    }

    static Pokemon pokemonParser(String[] readPokemon) {
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

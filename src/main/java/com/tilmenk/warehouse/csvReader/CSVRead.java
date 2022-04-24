package com.tilmenk.warehouse.csvReader;

import com.tilmenk.warehouse.pokemon.Pokemon;

import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public List<String[]> readLines(Reader reader){
        List<String[]> listOfRows = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
    }



}

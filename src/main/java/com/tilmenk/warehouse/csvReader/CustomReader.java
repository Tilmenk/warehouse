package com.tilmenk.warehouse.csvReader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CustomReader {

    List<String[]> readLines(String path) throws CsvValidationException, IOException, URISyntaxException {
        Reader reader = new BufferedReader(new FileReader(path));
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
}

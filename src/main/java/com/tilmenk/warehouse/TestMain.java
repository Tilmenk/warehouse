package com.tilmenk.warehouse;

import com.tilmenk.warehouse.util.csvReader.CustomReader;

import java.util.List;

import static com.tilmenk.warehouse.util.csvReader.CSVRead.parsePokemon;

public class TestMain {


    public static void main(String[] args) {
        CustomReader customReader = new CustomReader();
        try {
            List<String[]> result = customReader.readLines("src/main" +
                    "/resources" + "/csv" + "/pokemon_1.csv");
            result.remove(0);
            for (String[] stringArr : result) {
                System.out.println("------------------ STRING ARRAY ");
                for (String string : stringArr) {
                    System.out.println(string);
                }
                System.out.println(parsePokemon(stringArr));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

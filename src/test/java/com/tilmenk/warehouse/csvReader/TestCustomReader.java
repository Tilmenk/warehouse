package com.tilmenk.warehouse.csvReader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestCustomReader {

    @Test
    void testReadLines() {
        //GIVEN
        String path = "/src/test/com.tilmenk.warehouse/csvReader/testCSV.csv";
        CustomReader reader = new CustomReader();
        //WHEN
        List<String[]> result = null;
        try {
            result = reader.readLines(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
        //THEN
        assertEquals(4, result.size());
    }
}
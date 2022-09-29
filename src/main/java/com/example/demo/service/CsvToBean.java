package com.example.demo.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.example.demo.model.InventuraTable;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvToBean {

    private static final String inventuraCSV = "src/main/resources/inventuraVzor.csv";

    public List<InventuraTable> csvToBean() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(inventuraCSV));
        List<InventuraTable> list = new CsvToBeanBuilder(reader)
                .withType(InventuraTable.class)
                //withIgnoreLeadingWhiteSpace(true)
                .withSeparator(';')
                .build()
                .parse();

        return list;
    }
}



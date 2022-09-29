package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.InventuraTable;

@Service
public class InventuraService {

    CsvToBean toBean = new CsvToBean();

    public List<InventuraTable> getInventura() throws IOException {

        List<InventuraTable> inventuraTable = toBean.csvToBean();
        //System.out.println(inventuraTable.get(0).name);
        //return inventuraTable.get(1).name;
        //System.out.println(inventuraTable);
        return inventuraTable;

    }
}

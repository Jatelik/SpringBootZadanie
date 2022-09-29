package com.example.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.repository.InventuraRepository;
import com.example.demo.service.DeleteAll;
import com.example.demo.service.GetMajetok;
import com.example.demo.service.GetRooms;
import com.example.demo.service.InsertToDB;
import com.example.demo.service.PriceToComparable;

@RestController
@RequestMapping("/inventura")
public class UserController {

    private final InventuraRepository inventuraRepository;

    public UserController(InventuraRepository inventuraRepository) {
        this.inventuraRepository = inventuraRepository;
    }

    DeleteAll deleteAll = new DeleteAll();

    @RequestMapping("/deleteAll")
    @PutMapping
    public void deleteAll() throws SQLException {
        deleteAll.deleteAll();
    }

    InsertToDB insertToDB = new InsertToDB();

    @RequestMapping("/insertToDB")
    @PutMapping
    public void loadFromFile() throws IOException {
        insertToDB.insertToDB();
    }

    GetRooms getRooms = new GetRooms();

    @RequestMapping("/getRooms")
    @GetMapping
    public ArrayList<String> getRooms() {
        return getRooms.getRooms();
    }

    PriceToComparable priceToComparable = new PriceToComparable();
    GetMajetok getMajetok = new GetMajetok();

    @RequestMapping("/getMajetok")
    @GetMapping
    public ArrayList<String> getRooms(
            @RequestParam(required = true, defaultValue = "OK") String state) throws SQLException {
        priceToComparable.updatePrice();
        ArrayList<String> Majetok = getMajetok.getMajetok(state);
        priceToComparable.backToString();
        return Majetok;
    }
}


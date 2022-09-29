package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
@Entity
@Table(name = "inventura_table")
public class InventuraTable {

    @Id
    @CsvBindByName(column = "ID")
    public long id;

    @CsvBindByName(column = "NAME")
    public String name;

    @CsvBindByName(column = "ROOM")
    public String room;

    @CsvBindByName(column = "TYPE")
    public int type;

    @CsvBindByName(column = "PRICE")
    public String price;

    @CsvBindByName(column = "IN_DATE")
    public long inDate;

    @Nullable
    @CsvBindByName(column = "OUT_DATE")
    public String outDate;

    @CsvBindByName(column = "STATE")
    public String state;

}

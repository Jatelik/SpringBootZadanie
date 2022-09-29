package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InventuraTable;

public interface InventuraRepository extends JpaRepository<InventuraTable, Long> {

}

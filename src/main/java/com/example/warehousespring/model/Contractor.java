package com.example.warehousespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Contractor {

    @Id
    @GeneratedValue
    private Long id;
    private String symbol;
    private String name;

    Contractor() {
    }

    public Contractor(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

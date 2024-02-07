package com.example.warehousespring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ReceiptDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    @ManyToOne
    private Contractor contractor;

    ReceiptDocument() {
    }

    public ReceiptDocument(String symbol, Contractor contractor, List<DocumentItem> documentItemList) {
        this.symbol = symbol;
        this.contractor = contractor;
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

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}

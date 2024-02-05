package com.example.warehousespring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DocumentItem {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String unitOfMeasure;
    private Float amount;

    DocumentItem() {
    }

    public DocumentItem(String productName, String unitOfMeasure, Float amount) {
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}

package com.example.warehousespring.model;

import jakarta.persistence.*;

@Entity
public class DocumentItem {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String unitOfMeasure;
    private Float amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_document_id")
    private ReceiptDocument receiptDocument;

    public DocumentItem(String productName, String unitOfMeasure, Float amount, ReceiptDocument receiptDocument) {
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        this.amount = amount;
        this.receiptDocument = receiptDocument;
    }

    DocumentItem() {
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

    public ReceiptDocument getReceiptDocument() {
        return receiptDocument;
    }

    public void setReceiptDocument(ReceiptDocument receiptDocument) {
        this.receiptDocument = receiptDocument;
    }
}

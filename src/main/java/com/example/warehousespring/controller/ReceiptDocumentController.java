package com.example.warehousespring.controller;

import com.example.warehousespring.model.ReceiptDocument;
import com.example.warehousespring.repository.ReceiptDocumentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptDocumentController {

    private ReceiptDocumentRepository repository;

    ReceiptDocumentController(ReceiptDocumentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/receipt-document")
    List<ReceiptDocument> getAllReceiptDocuments() {
        return repository.findAll();
    }
}

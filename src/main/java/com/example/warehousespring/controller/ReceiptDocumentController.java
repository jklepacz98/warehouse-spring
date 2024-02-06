package com.example.warehousespring.controller;

import com.example.warehousespring.exception.ReceiptDocumentNotFoundException;
import com.example.warehousespring.model.ReceiptDocument;
import com.example.warehousespring.repository.ReceiptDocumentRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/receipt-document/{id}")
    ReceiptDocument getReceiptDocument(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ReceiptDocumentNotFoundException(id));
    }

    @PostMapping("/receipt-document")
    ReceiptDocument postReceiptDocument(@RequestBody ReceiptDocument receiptDocument) {
        receiptDocument.getDocumentItemList().forEach(documentItem ->
                documentItem.setReceiptDocument(receiptDocument)
        );
        return repository.save(receiptDocument);
    }

    @PutMapping("/receipt-document/{id}")
    ReceiptDocument postReceiptDocument(@RequestBody ReceiptDocument newReceiptDocument, @PathVariable Long id) {
        return repository.findById(id).map(receiptDocument -> {
            receiptDocument.setSymbol(newReceiptDocument.getSymbol());
            receiptDocument.setContractor(newReceiptDocument.getContractor());
            receiptDocument.getDocumentItemList().clear();
            newReceiptDocument.getDocumentItemList().forEach(documentItem -> {
                documentItem.setReceiptDocument(receiptDocument);
                receiptDocument.getDocumentItemList().add(documentItem);
            });
            return repository.save(receiptDocument);
        }).orElseGet(() -> {
            newReceiptDocument.getDocumentItemList().forEach(documentItem ->
                    documentItem.setReceiptDocument(newReceiptDocument)
            );
            return repository.save(newReceiptDocument);
        });
    }
}

package com.example.warehousespring.controller;

import com.example.warehousespring.exception.DocumentItemNotFoundException;
import com.example.warehousespring.model.DocumentItem;
import com.example.warehousespring.repository.DocumentItemReposiotory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentItemController {

    private DocumentItemReposiotory repository;

    DocumentItemController(DocumentItemReposiotory repository) {
        this.repository = repository;
    }

    @GetMapping("/document-item")
    List<DocumentItem> getAllDocumentItems() {
        return repository.findAll();
    }

    @GetMapping("/document-item/{id}")
    DocumentItem getDocumentItem(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new DocumentItemNotFoundException(id));
    }

    @PostMapping("/document-item")
    DocumentItem postDocumentItem(@RequestBody DocumentItem documentItem) {
        return repository.save(documentItem);
    }

    @PutMapping("document-item/{id}")
    DocumentItem putDocumentItem(@RequestBody DocumentItem newDocumentItem, @PathVariable Long id) {
        return repository.findById(id).map(documentItem -> {
            documentItem.setProductName(newDocumentItem.getProductName());
            documentItem.setUnitOfMeasure(newDocumentItem.getUnitOfMeasure());
            documentItem.setAmount(newDocumentItem.getAmount());
            return repository.save(documentItem);
        }).orElseGet(() -> {
            newDocumentItem.setId(id);
            return repository.save(newDocumentItem);
        });
    }

    @DeleteMapping("/document-item/{id}")
    void deleteDocumentItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

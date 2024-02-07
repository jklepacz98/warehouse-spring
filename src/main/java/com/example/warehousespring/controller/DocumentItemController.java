package com.example.warehousespring.controller;

import com.example.warehousespring.exception.DocumentItemNotFoundException;
import com.example.warehousespring.exception.ReceiptDocumentNotFoundException;
import com.example.warehousespring.model.DocumentItem;
import com.example.warehousespring.repository.DocumentItemReposiotory;
import com.example.warehousespring.repository.ReceiptDocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentItemController {

    private DocumentItemReposiotory documentItemRepository;

    private ReceiptDocumentRepository receiptDocumentRepository;

    DocumentItemController(
            DocumentItemReposiotory documentItemRepository,
            ReceiptDocumentRepository receiptDocumentRepository
    ) {
        this.documentItemRepository = documentItemRepository;
        this.receiptDocumentRepository = receiptDocumentRepository;
    }

    @GetMapping("/document-item")
    List<DocumentItem> getDocumentItems(@RequestParam(name = "receipt-document-id", required = false) Long receiptDocumentId) {
        if (receiptDocumentId != null) {
            return documentItemRepository.findByReceiptDocumentId(receiptDocumentId);
        } else {
            return documentItemRepository.findAll();
        }
    }

    @GetMapping("/document-item/{id}")
    DocumentItem getDocumentItem(@PathVariable Long id) {
        return documentItemRepository.findById(id).orElseThrow(() -> new DocumentItemNotFoundException(id));
    }

    @PostMapping("/document-item")
    DocumentItem postDocumentItem(@RequestBody DocumentItem documentItem) {
        Long receiptDocumentId = documentItem.getReceiptDocumentId();
        if (!receiptDocumentRepository.existsById(receiptDocumentId)) {
            throw new ReceiptDocumentNotFoundException(receiptDocumentId);
        }
        return documentItemRepository.save(documentItem);
    }

    @PutMapping("document-item/{id}")
    DocumentItem putDocumentItem(@RequestBody DocumentItem newDocumentItem, @PathVariable Long id) {
        Long receiptDocumentId = newDocumentItem.getReceiptDocumentId();
        if (!receiptDocumentRepository.existsById(receiptDocumentId)) {
            throw new ReceiptDocumentNotFoundException(receiptDocumentId);
        }

        return documentItemRepository.findById(id).map(documentItem -> {
            documentItem.setProductName(newDocumentItem.getProductName());
            documentItem.setUnitOfMeasure(newDocumentItem.getUnitOfMeasure());
            documentItem.setAmount(newDocumentItem.getAmount());
            return documentItemRepository.save(documentItem);
        }).orElseGet(() -> {
            newDocumentItem.setId(id);
            return documentItemRepository.save(newDocumentItem);
        });
    }
}

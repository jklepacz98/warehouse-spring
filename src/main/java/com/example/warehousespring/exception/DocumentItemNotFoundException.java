package com.example.warehousespring.exception;

public class DocumentItemNotFoundException extends RuntimeException {
    public DocumentItemNotFoundException(Long id) {
        super("Could not find document item " + id);
    }
}

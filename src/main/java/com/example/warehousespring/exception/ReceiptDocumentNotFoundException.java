package com.example.warehousespring.exception;

public class ReceiptDocumentNotFoundException extends RuntimeException {
    public ReceiptDocumentNotFoundException(Long id) {
        super("Could not find receipt document " + id);
    }
}

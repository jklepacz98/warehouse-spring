package com.example.warehousespring.exception;

public class ContractorNotFoundException extends RuntimeException {
    public ContractorNotFoundException(Long id) {
        super("Could not find contractor " + id);
    }
}

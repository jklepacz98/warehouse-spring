package com.example.warehousespring.repository;

import com.example.warehousespring.model.ReceiptDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptDocumentRepository extends JpaRepository<ReceiptDocument, Long> {
}

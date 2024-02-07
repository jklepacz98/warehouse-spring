package com.example.warehousespring.repository;

import com.example.warehousespring.model.DocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentItemReposiotory extends JpaRepository<DocumentItem, Long> {
    List<DocumentItem> findByReceiptDocumentId(Long receiptDocumentId);
}

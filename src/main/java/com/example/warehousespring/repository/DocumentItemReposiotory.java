package com.example.warehousespring.repository;

import com.example.warehousespring.model.DocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentItemReposiotory extends JpaRepository<DocumentItem, Long> {
}

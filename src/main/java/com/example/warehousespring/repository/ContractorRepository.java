package com.example.warehousespring.repository;

import com.example.warehousespring.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}

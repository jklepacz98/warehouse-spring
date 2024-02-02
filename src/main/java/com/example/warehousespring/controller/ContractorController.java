package com.example.warehousespring.controller;

import com.example.warehousespring.model.Contractor;
import com.example.warehousespring.repository.ContractorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractorController {

    private ContractorRepository repository;

    ContractorController(ContractorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contractor")
    List<Contractor> getAllContractors() {
        return repository.findAll();
    }

    @PostMapping("/contractor")
    Contractor postContractor(@RequestBody Contractor contractor) {
        return repository.save(contractor);
    }
}
